package com.nhnacdemy.kihunjung.tdd.mockito;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountServiceMockTest {
    private AccountService service;
    private AccountRepository repository;
    private Account account;

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);
    }

    @Test
    void login() {
        String username = "jordan";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        Account result = service.login(username, password);

        Assertions.assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isPositive();
        assertThat(result.getUsername()).isEqualTo(username);
        assertThat(result.getPassword()).isEqualTo(password);

        verify(repository).findByUsername(username);    // !! verify(mock)
    }

    @Test
    void login_usernameIsNull_throwIllegalArgumentException() {
        String username = null;
        String password = "P@s5w0rd";

        //        Account account = new Account(username, password);
        //        when(repository.findByUsername(username)).thenReturn(account);

        assertThatIllegalArgumentException().isThrownBy(() -> service.login(username, password))
            .withMessageContaining("null");

        verify(repository, never()).findByUsername(any());  // !! verify never
    }


    @DisplayName("한 계정에 대해서 비밀번호를 연속 3번 틀리면 계정이 잠기게 해주세요.")
    @Test
    void login_incorrectPassword3Times_lockAccount() {
        String username = "jordan";
        String password = "invalid.password";

        account = new Account(username, "valid.password");
        when(repository.findByUsername(username)).thenReturn(account);

        failLogin(username, password);
        failLogin(username, password);
        failLogin(username, password);

        Assertions.assertThat(account.isLock()).isTrue();

        verify(repository, times(3)).findByUsername(username);
    }

    @SuppressWarnings("CatchMayIgnoreException")
    private void failLogin(String username, String password) {
        try {
            service.login(username, password);
        } catch (LoginFailedException cause) {
        }
    }

    @DisplayName("계정이 잠기면 로그인할 수 없습니다.(`AccountLockedException` 예외가 발생합니다.)")
    @Test
    void login_accountIsLock_disabledLoginByAccountLockedException() {
        login_incorrectPassword3Times_lockAccount();

        String username = "jordan";
        String password = "invalid.password";

        assertThatThrownBy(() -> service.login(username, password))
            .isInstanceOf(AccountLockedException.class)
            .hasMessageContainingAll("lock", username);

        verify(repository, times(4)).findByUsername(username);
    }
}

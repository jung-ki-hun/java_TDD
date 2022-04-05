package com.nhnacdemy.kihunjung.tdd.mockito;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest
{
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account("jordan", "P@s5w0rd");
    }

    @Test
    void isLock_increaseLoginFailCount3Times_lock() {
        assertThat(account.isLock()).isFalse();
        // 로그인 1번 실패
        account.increaseLoginFailCount();
        assertThat(account.isLock()).isFalse();
        // 로그인 2번 실패
        account.increaseLoginFailCount();
        assertThat(account.isLock()).isFalse();
        // 로그인 3번 실패
        account.increaseLoginFailCount();
        assertThat(account.isLock()).isTrue();
    }

}

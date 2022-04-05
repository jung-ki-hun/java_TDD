package com.nhnacdemy.kihunjung.tdd.mockito;

import java.util.Objects;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void join(Account account) {
        repository.insert(account);
    }

    public Account login(String username, String password) {
        if (username == null) {
            throw new IllegalArgumentException("username is null");
        }
        Account found = repository.findByUsername(username);
        if (found == null) {
            return null;
        }
        if (found.isLock()) {
            throw new AccountLockedException(username);
        }
        if (!isMatchedPassword(password, found)) {
            found.increaseLoginFailCount();
            throw new LoginFailedException(username);
        }
        return found;
    }

    private boolean isMatchedPassword(String password, Account found) {
        return Objects.equals(found.getPassword(), password);
    }
}

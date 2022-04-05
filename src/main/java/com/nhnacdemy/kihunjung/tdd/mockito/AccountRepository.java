package com.nhnacdemy.kihunjung.tdd.mockito;

public interface AccountRepository {
    void insert(Account account);

    Account findByUsername(String username);
}

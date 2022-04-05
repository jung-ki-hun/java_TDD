package com.nhnacdemy.kihunjung.tdd.mockito;

import java.util.HashMap;

public class HashMapAccountRepository implements AccountRepository {
    HashMap<Long, Account> source = new HashMap<>();

    @Override
    public void insert(Account account) {
        source.put(account.getId(), account);
    }

    @Override
    public Account findByUsername(String username) {
        return null;
    }
}

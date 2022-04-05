package com.nhnacdemy.kihunjung.tdd.mockito;

public class DummyAccount extends Account {
    public DummyAccount() {
        super(null, null);
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
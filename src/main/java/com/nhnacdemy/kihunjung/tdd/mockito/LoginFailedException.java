package com.nhnacdemy.kihunjung.tdd.mockito;

public class LoginFailedException extends RuntimeException {

    public LoginFailedException(String username) {
        super("Login failed. Not matched password: " + username);
    }
}

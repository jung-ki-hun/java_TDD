package com.nhnacdemy.kihunjung.tdd;

public class Person {
    private final String firstName;
    private final String lastName;
    public Person(String jordan, String jeong) {
        firstName = jordan;
        lastName = jeong;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

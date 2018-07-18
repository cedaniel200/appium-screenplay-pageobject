package com.cedaniel200.eribank.screenplay.model;

import com.cedaniel200.eribank.screenplay.model.builder.UserBuilder;

public class User {

    private final String username;
    private final String password;

    public User(UserBuilder builder) {
        this.username = builder.getUsername();
        this.password = builder.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

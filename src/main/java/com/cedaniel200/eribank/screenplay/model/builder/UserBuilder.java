package com.cedaniel200.eribank.screenplay.model.builder;

import com.cedaniel200.eribank.screenplay.model.User;
import com.cedaniel200.eribank.screenplay.util.Builder;

public class UserBuilder implements Builder<User> {

    private String username;
    private String password;

    public UserBuilder(String username) {
        this.username = username;
    }

    public static UserBuilder user(String username){
        return new UserBuilder(username);
    }

    public User withPassword(String password) {
        this.password = password;
        return build();
    }

    @Override
    public User build() {
        return new User(this);
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}

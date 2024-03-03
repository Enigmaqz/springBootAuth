package ru.netology.springBootAuth.model;

import lombok.Getter;

@Getter
public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Added new User: %s Password: %s", this.login, this.password);
    }
}
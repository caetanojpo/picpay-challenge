package br.com.picpaychallenge.application.core.domain;

import br.com.picpaychallenge.application.core.enums.UserType;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String document;
    private String email;
    private String password;
    private UserType userType;

    public User() {
    }

    public User(UUID id, String name, String document, String email, String password, UserType userType) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}

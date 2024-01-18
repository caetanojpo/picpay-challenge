package br.com.picpaychallenge.domain.user.dto;

import br.com.picpaychallenge.domain.user.enums.UserType;

public class UserRequest {

    private String name;
    private String document;
    private String email;
    private String password;
    private UserType userType;

    public UserRequest(String name, String document, String email, String password, UserType userType) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
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
}

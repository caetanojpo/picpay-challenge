package br.com.picpaychallenge.domain.user;

import br.com.picpaychallenge.domain.user.dto.UserRequest;
import br.com.picpaychallenge.domain.user.enums.UserType;

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

    public User(UserRequest userRequest) {
        this.name = userRequest.getName();
        this.document = userRequest.getDocument();
        this.email = userRequest.getEmail();
        this.password = userRequest.getPassword();
        this.userType = userRequest.getUserType();
    }

    public UserRequest toUserRequest() {
        return new UserRequest(this.name, this.document, this.email, this.password, this.userType);
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
}

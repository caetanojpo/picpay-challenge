package br.com.picpaychallenge.application.core.service;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.inbound.CreateUserServicePort;
import br.com.picpaychallenge.application.ports.outbound.CreateUserPort;
import br.com.picpaychallenge.application.ports.outbound.EncryptPasswordPort;

public class CreateUserService implements CreateUserServicePort, EncryptPasswordPort {

    private final CreateUserPort repository;

    public CreateUserService(CreateUserPort repository) {
        this.repository = repository;
    }

    @Override
    public User execute(User user) {

        return this.repository.save(user);
    }

    @Override
    public String encrypt(String password) {
        return null;
    }
}

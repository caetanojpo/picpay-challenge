package br.com.picpaychallenge.application.core.usecase;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.cryptography.EncryptPassword;
import br.com.picpaychallenge.application.ports.outbound.UserRepository;

public class CreateUser {

    private final UserRepository repository;

    private final EncryptPassword encryptPassword;

    public CreateUser(UserRepository repository, EncryptPassword encryptPassword) {
        this.repository = repository;
        this.encryptPassword = encryptPassword;
    }

    public User execute(User user) {
        user.setPassword(encryptPassword.encode(user.getPassword()));
        return this.repository.save(user);
    }

}

package br.com.picpaychallenge.application.core.usecase;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.cryptography.EncryptPassword;
import br.com.picpaychallenge.application.ports.outbound.UserRepository;

public class CreateUser {

    private final UserRepository userRepository;
    private final CreateWallet createWallet;

    private final EncryptPassword encryptPassword;

    public CreateUser(UserRepository repository, CreateWallet createWallet, EncryptPassword encryptPassword) {
        this.userRepository = repository;
        this.createWallet = createWallet;
        this.encryptPassword = encryptPassword;
    }

    public User execute(User user) {
        user.setPassword(encryptPassword.encode(user.getPassword()));
        var createdUser = this.userRepository.save(user);
        createWallet.execute(createdUser);
        return createdUser;

    }

}

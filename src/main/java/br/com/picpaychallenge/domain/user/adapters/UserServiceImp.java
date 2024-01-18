package br.com.picpaychallenge.domain.user.adapters;

import br.com.picpaychallenge.domain.user.User;
import br.com.picpaychallenge.domain.user.dto.UserRequest;
import br.com.picpaychallenge.domain.user.ports.interfaces.UserServicePort;
import br.com.picpaychallenge.domain.user.ports.repositories.UserRepositoryPort;

import java.util.List;

public class UserServiceImp implements UserServicePort {

    private final UserRepositoryPort repository;

    public UserServiceImp(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<User> listProducts() {
        return this.repository.findAll();

    }

    @Override
    public void createUser(UserRequest userRequest) {
        User user = new User(userRequest);
        this.repository.save(user);
    }

}

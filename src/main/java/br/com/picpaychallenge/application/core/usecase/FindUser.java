package br.com.picpaychallenge.application.core.usecase;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.outbound.UserRepository;

import java.util.List;
import java.util.UUID;

public class FindUser {

    private final UserRepository repository;

    public FindUser(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> all() {
        return repository.findAll();
    }

    public User byId(UUID id) { return repository.byId(id);}
}

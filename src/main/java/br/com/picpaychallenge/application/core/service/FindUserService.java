package br.com.picpaychallenge.application.core.service;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.outbound.CreateUserPort;
import br.com.picpaychallenge.application.ports.outbound.FindUserPort;

import java.util.List;

public class FindUserService {

    private final FindUserPort repository;

    public FindUserService(FindUserPort repository) {
        this.repository = repository;
    }

    public List<User> all(){
        return repository.findAll();
    }
}

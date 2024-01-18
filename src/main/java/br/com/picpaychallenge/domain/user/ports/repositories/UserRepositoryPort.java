package br.com.picpaychallenge.domain.user.ports.repositories;

import br.com.picpaychallenge.domain.user.User;
import br.com.picpaychallenge.domain.user.dto.UserRequest;

import java.util.List;

public interface UserRepositoryPort {
    List<User> findAll();

    void save(User user);
}

package br.com.picpaychallenge.application.ports.outbound;

import br.com.picpaychallenge.application.core.domain.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> findAll();
}

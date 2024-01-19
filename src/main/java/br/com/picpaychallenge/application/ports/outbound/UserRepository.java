package br.com.picpaychallenge.application.ports.outbound;

import br.com.picpaychallenge.application.core.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    User byId(UUID id);
}

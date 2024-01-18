package br.com.picpaychallenge.application.ports.inbound;

import br.com.picpaychallenge.application.core.domain.User;

public interface CreateUserServicePort {
    User execute(User user);
}

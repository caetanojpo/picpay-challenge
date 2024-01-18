package br.com.picpaychallenge.application.ports.outbound;

import br.com.picpaychallenge.application.core.domain.User;

public interface CreateUserPort {
    User save(User user);
}

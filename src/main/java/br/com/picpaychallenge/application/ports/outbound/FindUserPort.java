package br.com.picpaychallenge.application.ports.outbound;

import br.com.picpaychallenge.application.core.domain.User;

import java.util.List;

public interface FindUserPort {

    List<User> findAll();
}

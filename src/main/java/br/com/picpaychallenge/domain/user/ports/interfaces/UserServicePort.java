package br.com.picpaychallenge.domain.user.ports.interfaces;

import br.com.picpaychallenge.domain.user.User;
import br.com.picpaychallenge.domain.user.dto.UserRequest;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserServicePort {

    List<User> listProducts();

void createUser(UserRequest userRequest);

}

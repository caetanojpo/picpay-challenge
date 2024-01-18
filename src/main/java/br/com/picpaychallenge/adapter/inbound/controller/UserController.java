package br.com.picpaychallenge.adapter.inbound.controller;

import br.com.picpaychallenge.adapter.inbound.dto.request.UserRequest;
import br.com.picpaychallenge.adapter.inbound.mapper.UserMapper;
import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.outbound.CreateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserPort createUserPort;

    @PostMapping
    public User saveUser(@RequestBody UserRequest userRequest) {
        User user = UserMapper.INSTANCE.toUserFromUserRequest(userRequest);
        return createUserPort.save(user);
    }
}

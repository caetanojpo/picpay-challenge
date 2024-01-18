package br.com.picpaychallenge.adapter.outbound.service;

import br.com.picpaychallenge.adapter.inbound.mapper.UserMapper;
import br.com.picpaychallenge.adapter.outbound.entity.UserEntity;
import br.com.picpaychallenge.adapter.outbound.repository.UserRepository;
import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.outbound.CreateUserPort;
import br.com.picpaychallenge.application.ports.outbound.EncryptPasswordPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserAdapter implements CreateUserPort, EncryptPasswordPort {

    private final UserRepository repository;

    @Transactional
    @Override
    public User save(User user) {
        String rawPassword = user.getPassword();

        user.setPassword(encrypt(rawPassword));

        UserEntity userEntity = UserMapper.INSTANCE.toUserEntityFromUser(user);

        return UserMapper.INSTANCE.toUserFromUserEntity(repository.save(userEntity));
    }

    @Override
    public String encrypt(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}

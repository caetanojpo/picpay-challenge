package br.com.picpaychallenge.adapter.outbound.repository;

import br.com.picpaychallenge.adapter.inbound.mapper.UserMapper;
import br.com.picpaychallenge.adapter.outbound.cryptography.Argon2Password;
import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.outbound.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserEntityRepository implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final Argon2Password bCryptPassword;

    @Override
    public User save(User user) {
        var userEntity = UserMapper.INSTANCE.toUserEntity(user);
        return UserMapper.INSTANCE.toUser(jpaRepository.save(userEntity));
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User byId(UUID id) {
        return UserMapper.INSTANCE.toUser(jpaRepository.findById(id));
    }
}

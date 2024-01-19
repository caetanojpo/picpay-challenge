package br.com.picpaychallenge.adapter.outbound.repository;

import br.com.picpaychallenge.adapter.inbound.mapper.UserMapper;
import br.com.picpaychallenge.adapter.outbound.cryptography.BCryptPassword;
import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.ports.outbound.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserEntityRepository implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserMapper userMapper;
    private final BCryptPassword bCryptPassword;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPassword.encode(user.getPassword()));
        var userEntity = userMapper.toUserEntity(user);
        return userMapper.toUser(jpaRepository.save(userEntity));
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}

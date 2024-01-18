package br.com.picpaychallenge.adapter.outbound.repository;

import br.com.picpaychallenge.adapter.outbound.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

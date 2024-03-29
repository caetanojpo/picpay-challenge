package br.com.picpaychallenge.adapter.outbound.repository;

import br.com.picpaychallenge.adapter.outbound.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
}

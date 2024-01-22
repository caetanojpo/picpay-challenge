package br.com.picpaychallenge.adapter.inbound.mapper;

import br.com.picpaychallenge.adapter.inbound.dto.request.UserRequest;
import br.com.picpaychallenge.adapter.outbound.entity.UserEntity;
import br.com.picpaychallenge.application.core.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequest userRequest);
    User toUser(UserEntity userEntity);
    User toUser(Optional<UserEntity> optionalUserEntity);

    UserEntity toUserEntity(User user);


}

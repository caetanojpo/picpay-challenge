package br.com.picpaychallenge.adapter.inbound.dto.request;

import br.com.picpaychallenge.application.core.enums.UserType;

public record UserRequest(
        String name,
        String document,
        String email,
        String password,
        UserType userType
) {
}

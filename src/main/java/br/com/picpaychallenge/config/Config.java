package br.com.picpaychallenge.config;

import br.com.picpaychallenge.adapter.outbound.service.CreateUserAdapter;
import br.com.picpaychallenge.application.core.service.CreateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateUserService createUserService(CreateUserAdapter createUserAdapter) {
        return new CreateUserService(createUserAdapter);
    }

}

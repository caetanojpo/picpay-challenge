package br.com.picpaychallenge.config;

import br.com.picpaychallenge.application.core.usecase.CreateUser;
import br.com.picpaychallenge.application.ports.cryptography.EncryptPassword;
import br.com.picpaychallenge.application.ports.outbound.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateUser createUserService(UserRepository repository, EncryptPassword encryptPassword) {
        return new CreateUser(repository, encryptPassword);
    }

}

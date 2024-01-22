package br.com.picpaychallenge.config;

import br.com.picpaychallenge.application.core.usecase.*;
import br.com.picpaychallenge.application.ports.cryptography.EncryptPassword;
import br.com.picpaychallenge.application.ports.outbound.UserRepository;
import br.com.picpaychallenge.application.ports.outbound.WalletRepository;
import br.com.picpaychallenge.application.ports.rest.HttpRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateUser createUserService(UserRepository userRepository, CreateWallet createWallet, EncryptPassword encryptPassword) {
        return new CreateUser(userRepository, createWallet, encryptPassword);
    }

    @Bean
    public CreateWallet createWalletService(WalletRepository walletRepository) {
        return new CreateWallet(walletRepository);
    }

    @Bean
    UpdateWallet updateWallet(WalletRepository walletRepository, FindUser findUser, FindWallet findWallet, HttpRequest httpRequest) {
        return new UpdateWallet(walletRepository, findUser, findWallet, httpRequest);
    }

}

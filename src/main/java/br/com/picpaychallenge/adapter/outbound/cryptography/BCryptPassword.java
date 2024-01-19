package br.com.picpaychallenge.adapter.outbound.cryptography;

import br.com.picpaychallenge.application.ports.cryptography.EncryptPassword;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPassword implements EncryptPassword {


    @Override
    public String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}

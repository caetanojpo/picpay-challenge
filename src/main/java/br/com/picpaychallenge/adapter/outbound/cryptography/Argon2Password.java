package br.com.picpaychallenge.adapter.outbound.cryptography;

import br.com.picpaychallenge.application.ports.cryptography.EncryptPassword;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Argon2Password implements EncryptPassword {

    @Override
    public String encode(String password) {
        return Argon2Factory.create().hash(10, 65536, 1, password.getBytes(StandardCharsets.UTF_8));
    }
}

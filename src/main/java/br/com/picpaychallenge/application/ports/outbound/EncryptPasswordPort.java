package br.com.picpaychallenge.application.ports.outbound;

public interface EncryptPasswordPort {
    String encrypt(String password);
}

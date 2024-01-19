package br.com.picpaychallenge.application.core.usecase;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.core.domain.Wallet;
import br.com.picpaychallenge.application.ports.outbound.WalletRepository;

import java.math.BigDecimal;

public class CreateWallet {

    private final WalletRepository repository;

    public CreateWallet(WalletRepository repository) {
        this.repository = repository;
    }

    public Wallet execute(User user) {
        Wallet wallet = new Wallet();
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setUser(user);
        return this.repository.save(wallet);
    }
}

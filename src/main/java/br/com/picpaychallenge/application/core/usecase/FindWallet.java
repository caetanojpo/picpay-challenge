package br.com.picpaychallenge.application.core.usecase;

import br.com.picpaychallenge.application.core.domain.Wallet;
import br.com.picpaychallenge.application.ports.outbound.WalletRepository;

import java.util.UUID;

public class FindWallet {

    private final WalletRepository repository;

    public FindWallet(WalletRepository repository) {
        this.repository = repository;
    }

    public Wallet byUserId(UUID userId){
        return repository.byUserId(userId);
    }

    public Wallet byId(UUID id){
        return repository.byId(id);
    }
}

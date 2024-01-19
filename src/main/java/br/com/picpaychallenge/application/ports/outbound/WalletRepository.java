package br.com.picpaychallenge.application.ports.outbound;

import br.com.picpaychallenge.application.core.domain.Wallet;

import java.util.UUID;

public interface WalletRepository {
    Wallet save(Wallet wallet);

    Wallet byUserId(UUID userId);
}

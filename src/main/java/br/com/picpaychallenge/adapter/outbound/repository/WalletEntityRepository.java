package br.com.picpaychallenge.adapter.outbound.repository;

import br.com.picpaychallenge.adapter.inbound.mapper.WalletMapper;
import br.com.picpaychallenge.application.core.domain.Wallet;
import br.com.picpaychallenge.application.ports.outbound.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WalletEntityRepository implements WalletRepository {

    private final WalletJpaRepository walletJpaRepository;

    @Override
    public Wallet save(Wallet wallet) {
        var walletEntity = WalletMapper.INSTANCE.toWalletEntity(wallet);
        var createdWallet = WalletMapper.INSTANCE.toWallet(walletJpaRepository.save(walletEntity));
        return createdWallet;
    }
}

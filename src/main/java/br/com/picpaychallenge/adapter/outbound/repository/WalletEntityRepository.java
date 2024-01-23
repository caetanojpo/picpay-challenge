package br.com.picpaychallenge.adapter.outbound.repository;

import br.com.picpaychallenge.adapter.inbound.mapper.WalletMapper;
import br.com.picpaychallenge.application.core.domain.Wallet;
import br.com.picpaychallenge.application.core.exception.EntityNotFoundException;
import br.com.picpaychallenge.application.ports.outbound.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

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

    @Override
    public Wallet byId(UUID id) {
        return WalletMapper.INSTANCE.toWallet(walletJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Wallet.class.getSimpleName(), id)));
    }

    @Override
    public Wallet byUserId(UUID userId) {
        return WalletMapper.INSTANCE.toWallet(walletJpaRepository.findByUserId(userId).orElseThrow(() -> new EntityNotFoundException(Wallet.class.getSimpleName(), userId)));
    }

    @Override
    public Wallet update(UUID userId, BigDecimal value) {
        return null;
    }
}

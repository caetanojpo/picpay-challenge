package br.com.picpaychallenge.adapter.inbound.mapper;

import br.com.picpaychallenge.adapter.outbound.entity.WalletEntity;
import br.com.picpaychallenge.application.core.domain.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WalletMapper {

    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);

    WalletEntity toWalletEntity(Wallet wallet);

    Wallet toWallet(WalletEntity walletEntity);
}

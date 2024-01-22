package br.com.picpaychallenge.adapter.inbound.controller;

import br.com.picpaychallenge.adapter.inbound.dto.request.TransferRequest;
import br.com.picpaychallenge.application.core.domain.Wallet;
import br.com.picpaychallenge.application.core.usecase.CreateWallet;
import br.com.picpaychallenge.application.core.usecase.UpdateWallet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final CreateWallet createWallet;
    private final UpdateWallet updateWallet;

    @PutMapping("/transfer/{userId}")
    public Wallet transfer(@PathVariable UUID userId, @RequestBody TransferRequest transferRequest){

        return updateWallet.transfer(userId, transferRequest.value(), transferRequest.destinationAccount());
    }

}

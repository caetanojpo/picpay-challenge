package br.com.picpaychallenge.adapter.inbound.controller;

import br.com.picpaychallenge.application.core.usecase.CreateWallet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final CreateWallet createWallet;
}

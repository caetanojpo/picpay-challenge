package br.com.picpaychallenge.application.core.usecase;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.core.domain.Wallet;
import br.com.picpaychallenge.application.core.enums.TransactionType;
import br.com.picpaychallenge.application.core.enums.UserType;
import br.com.picpaychallenge.application.core.exception.UserException;
import br.com.picpaychallenge.application.core.exception.WalletException;
import br.com.picpaychallenge.application.ports.outbound.WalletRepository;
import br.com.picpaychallenge.application.ports.rest.HttpRequest;

import java.math.BigDecimal;
import java.util.UUID;

public class UpdateWallet {

    private final WalletRepository repository;
    private final FindUser findUser;
    private final FindWallet find;
    private final HttpRequest httpRequest;

    public UpdateWallet(WalletRepository repository, FindUser findUser, FindWallet find, HttpRequest httpRequest) {
        this.repository = repository;
        this.findUser = findUser;
        this.find = find;
        this.httpRequest = httpRequest;
    }

    public Wallet transfer(UUID userId, BigDecimal transactionValue, UUID destinationAccount) {

        User user = findUser.byId(userId);

        validateClientToMakeTransaction(user);

        Wallet userWallet = find.byUserId(userId);

        balanceValidations(userWallet.getBalance(), transactionValue);

        Wallet destinationWallet = find.byId(destinationAccount);
        try {
            transaction(destinationWallet.getId(), TransactionType.CREDIT, transactionValue);
            authorizeTransaction();
        } catch (RuntimeException ex) {
            transaction(userWallet.getId(), TransactionType.CREDIT, transactionValue);
            transaction(destinationWallet.getId(), TransactionType.DEBIT, transactionValue);
            throw new WalletException(ex.getMessage());
        }
        notifyViaEmail();
        return destinationWallet;
    }

    public void transaction(UUID walletId, TransactionType transactionType, BigDecimal value) {
        Wallet wallet = find.byId(walletId);
        if (transactionType.equals(TransactionType.CREDIT)) {
            wallet.setBalance(wallet.getBalance().add(value));
        } else {
            wallet.setBalance(wallet.getBalance().subtract(value));
        }
        repository.save(wallet);
    }

    private void validateClientToMakeTransaction(User user) {
        UserType userType = user.getUserType();

        if (userType.equals(UserType.SELLER)) {
            throw new UserException("Sellers can't make transactions");
        }

    }

    private void balanceValidations(BigDecimal balance, BigDecimal transactionValue) {
        if (balance.equals(BigDecimal.valueOf(0))) {
            throw new WalletException("Your Balance is equals 0.00, you can't make new transactions");
        }

        if (balance.compareTo(transactionValue) < 0) {
            throw new WalletException("You don't have enough balance to make this transaction, current balance: " + balance);
        }
    }

    private void authorizeTransaction() {
        if (!httpRequest.transactionValidations("/5794d450-d2e2-4412-8131-73d0293ac1cc").message().equals("Autorizado")) {
            throw new WalletException("Unauthorized");
        }
    }

    private void notifyViaEmail() {
        if (!httpRequest.transactionValidations("/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6").message().equals(true)){
            throw new WalletException("Notification failed");
        }
    }
}

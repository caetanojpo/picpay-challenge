package br.com.picpaychallenge.application.core.usecase;

import br.com.picpaychallenge.application.core.domain.User;
import br.com.picpaychallenge.application.core.domain.Wallet;
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

        Wallet wallet = find.byUserId(userId);

        balanceValidations(wallet.getBalance(), transactionValue);

        authorizeTransaction();


        return null;
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

    private String authorizeTransaction(){
        return httpRequest.getTransactionAuthorization();
    }
}

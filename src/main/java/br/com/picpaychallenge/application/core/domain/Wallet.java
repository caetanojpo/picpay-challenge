package br.com.picpaychallenge.application.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Wallet {

    private UUID id;
    private BigDecimal balance;
    private User user;

    public Wallet() {
    }

    public Wallet(UUID id, BigDecimal balance, User user) {
        this.id = id;
        this.balance = balance;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

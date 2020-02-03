package com.example.test.practice.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * @author myeongju.jung
 */
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long accountId;
    // 예금주
    private String depositor;
    // 잔액
    private long balance;
    private ZonedDateTime createdAt;

    @Override
    public String toString() {
        return "Account{" +
               "accountId=" + accountId +
               ", depositor='" + depositor + '\'' +
               ", balance=" + balance +
               ", createdAt=" + createdAt +
               '}';
    }

    @SuppressWarnings("WeakerAccess")
    Account() {
    }

    public Account (long balance, String depositor) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance must be greater than 0");
        }
        this.balance = balance;
        this.depositor = depositor;
        this.createdAt = ZonedDateTime.now();
    }

    public Long getAccountId() {
        return accountId;
    }

    public long getBalance() {
        return balance;
    }

    public String getDepositor() {
        return depositor;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void deposit(long money) {
        this.balance += money;
    }

    public void withDraw(long money) {
        if (money > balance) {
            throw new BalanceNotEnoughException();
        }
        this.balance -= money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) &&
               balance == account.balance &&
               Objects.equals(createdAt, account.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance, createdAt);
    }
}

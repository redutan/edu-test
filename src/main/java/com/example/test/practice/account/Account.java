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

    @SuppressWarnings("WeakerAccess")
    Account() {
    }

    public static Account forCreate(long balance, String depositor) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance must be greater than 0");
        }
        Account result = new Account();
        result.balance = balance;
        result.depositor = depositor;
        result.createdAt = ZonedDateTime.now();
        return result;
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
        this.balance -= money;
    }

    @Override
    public String toString() {
        return "Account{" +
               "accountId=" + accountId +
               ", balance='" + balance + '\'' +
               ", createdAt=" + createdAt +
               '}';
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

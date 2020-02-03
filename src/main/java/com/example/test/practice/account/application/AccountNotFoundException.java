package com.example.test.practice.account.application;

/**
 * @author myeongju.jung
 */
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long accountId) {
        super("계좌를 찾을 수가 없습니다: " + accountId);
    }
}

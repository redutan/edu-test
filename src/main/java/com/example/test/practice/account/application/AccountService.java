package com.example.test.practice.account.application;

import com.example.test.practice.account.Account;
import com.example.test.practice.account.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author myeongju.jung
 */
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(Long accountId) {
        Account result = accountRepository.findOne(accountId);
        if (result == null) {
            throw new AccountNotFoundException(accountId);
        }
        return result;
    }
}

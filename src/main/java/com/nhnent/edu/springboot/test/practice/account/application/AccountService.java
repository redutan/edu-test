package com.nhnent.edu.springboot.test.practice.account.application;

import com.nhnent.edu.springboot.test.practice.account.Account;
import com.nhnent.edu.springboot.test.practice.account.AccountRepository;
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
        return accountRepository.findOne(accountId);
    }
}

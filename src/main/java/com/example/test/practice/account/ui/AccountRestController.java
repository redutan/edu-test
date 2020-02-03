package com.example.test.practice.account.ui;

import com.example.test.practice.account.application.AccountService;
import com.example.test.practice.account.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author myeongju.jung
 */
@RestController
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/accounts")
    public List<Account> accounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/api/accounts/{accountId}")
    public Account account(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }
}

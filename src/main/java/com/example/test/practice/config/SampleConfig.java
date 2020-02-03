package com.example.test.practice.config;

import com.example.test.practice.account.Account;
import com.example.test.practice.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SampleConfig {
    private final AccountRepository accountRepository;

    @Autowired
    public SampleConfig(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Bean
    CommandLineRunner createAccounts() {
        return (String... args) -> {
            List<Account> accounts = Arrays.asList(
                    new Account(20_000L, "mandoo"),
                    new Account(50_000L, "jordan"),
                    new Account(100_000L, "dongmyo"),
                    new Account(1_000L, "doogi"),
                    new Account(0L, "comtin"),
                    new Account(2_000_000L, "franky"),
                    new Account(30_000, "manty"),
                    new Account(20_000, "bureung"));
            accountRepository.saveAll(accounts);
        };
    }
}

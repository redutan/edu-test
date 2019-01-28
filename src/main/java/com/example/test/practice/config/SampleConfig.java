package com.example.test.practice.config;

import com.example.test.practice.account.Account;
import com.example.test.practice.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SampleConfig {
    private final AccountRepository accountRepository;

    @Autowired
    public SampleConfig(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Bean
    CommandLineRunner createAccounts() {
        return (String... args) -> accountRepository.save(Arrays.asList(
                Account.forCreate(20_000L, "mandoo"),
                Account.forCreate(50_000L, "jordan"),
                Account.forCreate(100_000L, "dongmyo"),
                Account.forCreate(1_000L, "doogi"),
                Account.forCreate(0L, "comtin"),
                Account.forCreate(2_000_000L, "franky"),
                Account.forCreate(30_000, "manty"),
                Account.forCreate(20_000, "bureung")));
    }
}

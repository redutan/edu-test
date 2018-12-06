package com.nhnent.edu.springboot.test.practice.config;

import com.nhnent.edu.springboot.test.practice.account.Account;
import com.nhnent.edu.springboot.test.practice.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SampleConfig {
    @Autowired
    AccountRepository accountRepository;

    @Bean
    CommandLineRunner createAccounts() {
        return (String... args) -> accountRepository.save(Arrays.asList(
            Account.forCreate("mandoo", "SKY"),
            Account.forCreate("jordan", "JMJ"),
            Account.forCreate("dongmyo", "SDM"),
            Account.forCreate("doogi", "LSM"),
            Account.forCreate("comtin", "LKH"),
            Account.forCreate("franky", "PJM"),
            Account.forCreate("many", "JJB"),
            Account.forCreate("bureung", "KBB")));
    }
}

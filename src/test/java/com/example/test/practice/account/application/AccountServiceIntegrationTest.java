package com.example.test.practice.account.application;

import com.example.test.practice.account.Account;
import com.example.test.practice.config.SampleConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author myeongju.jung
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)    // !!
public class AccountServiceIntegrationTest {
    @Autowired
    AccountService service;

    @Test
    public void getAccounts() {
        // given
        // when
        List<Account> accounts = service.getAccounts();
        // then
        assertThat(accounts, hasSize(8));
        accounts.forEach(this::assertAccount);
    }

    private void assertAccount(Account account) {
        assertThat(account.getAccountId(), is(notNullValue()));
        assertThat(account.getBalance(), is(greaterThanOrEqualTo(0L)));
        assertThat(account.getDepositor(), is(notNullValue()));
        assertThat(account.getCreatedAt(), is(notNullValue()));
    }

    /**
     * 첫번째 계정을 조회하고 내용을 검증하는 테스트케이스 입니다.
     *
     * Hint : {@link SampleConfig}
     */
    @Test
    public void getAccount() {
        // given
        Long accountId = 1L;
        // when
        Account account = service.getAccount(accountId);
        // then
        assertThat(account.getAccountId(), is(accountId));
        // TODO 2-1: 테스트가 통과할 수 있도록 아래 코드들을 수정해 주세요.
        assertThat(account.getBalance(), is(0L));
        assertThat(account.getDepositor(), is(""));
        assertThat(account.getCreatedAt(), is(lessThan(null)));
    }
}

package com.example.test.practice.account.application;

import com.example.test.practice.account.Account;
import com.example.test.practice.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author myeongju.jung
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;

    @Test
    public void getAccount() {
        // given
        final Long accountId = 12L;

        Account account = new Account(10_000, "jordan");
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        // when
        Account result = accountService.getAccount(accountId);
        // then
        assertThat(result, is(account));
        verify(accountRepository).findById(accountId);
    }

    @Test(expected = AccountNotFoundException.class)
    public void getAccount_notExists() {
        // given
        final Long accountId = 13L;

        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());
        // when
        @SuppressWarnings("unused")
        Account result = accountService.getAccount(accountId);
        // then
    }
}
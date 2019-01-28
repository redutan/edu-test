package com.example.test.practice.account.application;

import com.example.test.practice.account.Account;
import com.example.test.practice.account.AccountRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * @author myeongju.jung
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceExceptionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;

    @Test(expected = AccountNotFoundException.class)
    public void getAccount_notExists() {
        // given
        final Long accountId = 13L;

        when(accountRepository.findOne(accountId)).thenReturn(null);
        // when
        @SuppressWarnings("unused")
        Account result = accountService.getAccount(accountId);
        // then
        System.out.println("End getAccount_notExists"); // 실행 안 됨
    }

    // TODO 해당 테스트 오류를 수정하시오
    @Test
    public void getAccount_notExists2() {
        // given
        final Long accountId = 13L;

        thrown.expect(AccountNotFoundException.class);
        thrown.expectMessage("계좌를 찾을 수가 없습니다 : ");

        when(accountRepository.findOne(accountId)).thenReturn(null);
        // when
        @SuppressWarnings("unused")
        Account result = accountService.getAccount(accountId);
        // then
        System.out.println("End getAccount_notExists2");    // 실행 안 됨
    }
}
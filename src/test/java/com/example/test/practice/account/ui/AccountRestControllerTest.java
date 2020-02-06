package com.example.test.practice.account.ui;

import com.example.test.practice.account.Account;
import com.example.test.practice.account.application.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * WebMvcTest와 MockBean을 이용한 Controller 테스트입니다.
 */
@RunWith(SpringRunner.class)
/*
 * TODO 1-1: AccountRestController 만 테스트 할 수 있도록 WebMvcTest 애너테이션을 설정해 주세요.
 *
 * hint : @Web___Test(AccountRestController.class)
 */
@WebMvcTest
public class AccountRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    /*
     * TODO 1-2: AccountService는 실제 구현체를 사용하지 않고 Mocking 하여 설정해 주세요.
     * <p>
     * hint : @M___B___
     */
    @MockBean
    AccountService accountService;

    @Test
    public void getAccount() throws Exception {
        // given
        Long accountId = random(Long.class);
        Account account = random(Account.class);
        given(accountService.getAccount(accountId)).willReturn(account);
        // when
        mockMvc.perform(get("/api/accounts/{0}", accountId)
                                .accept(MediaType.APPLICATION_JSON))
               // then
               // TODO 1-3: 요청의 결과는 200 OK 입니다. 검증 코드를 수정해 주세요.
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.accountId").value(account.getAccountId()))
               .andExpect(jsonPath("$.balance").value(account.getBalance()))
        ;
        // then2
        // TODO 1-4: 이 테스트케이스에서 accountService 는 1회 실행됩니다. 아래에서 잘 못된 부분을 수정해 주세요.
        then(accountService).should(times(1)).getAccount(accountId);
    }
}

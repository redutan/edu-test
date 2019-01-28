package com.example.test.practice.account;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author myeongju.jung
 */
@SuppressWarnings("RedundantThrows")
public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = Account.forCreate(10_000L, "jordan");
    }

    @Test
    public void getBalance() throws Exception {
        assertEquals("10,000원으로 계좌 생성 후 잔고 조회", 10_000L, account.getBalance());

        account = Account.forCreate(1_000L, "comptin");
        assertEquals("1,000원으로 계좌 생성 후 잔고 조회", 1_000L, account.getBalance());

        account = Account.forCreate(0L, "mandoo");
        assertEquals("0원으로 계좌 생성 후 잔고 조회", 0L, account.getBalance());
    }

    @Test
    public void deposit() throws Exception {
        account.deposit(1_000L);
        assertEquals(11_000L, account.getBalance());
    }

    @Test
    public void withdraw() throws Exception {
        account.withDraw(1_000L);
        assertEquals(9_000L, account.getBalance());
    }
}
package com.example.test.practice.refund;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author myeongju.jung
 */
@RunWith(Parameterized.class)   // 파라메터화된 테스트를 위한 선언
public class RefundServiceTest {

    // @Parameter로 주입 시 public 으로 선언되어야 한다.
    @SuppressWarnings("DefaultAnnotationParam")
    @Parameterized.Parameter(0)   // data() 항 항목의 첫번째 인자
    public long amount;
    @Parameterized.Parameter(1)   // data() 항 항목의 두번째 인자
    public long refundFee;

    Order order;
    RefundService refundService;

    // 파라미터들 제공 메소드 : static 이면서 Collection을 반환해야한다. 경계영역이 잘 설정되어야함.
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        // TODO 3-1: 테스트가 성공할 수 있게 환불수수료를 적절하게 수정하시오
        return Arrays.asList(new Object[][]{
                {9999L, 0L},
                {10000L, 1_000L},
                {49999L, 4_999L},
                {50000L, 10_000L}
        });
    }

    @Before
    public void setUp() {
        refundService = new RefundService();
        order = new Order(amount);
    }

    @Test
    public void testGetRefundFee() {
        System.out.println(order);
        assertThat(refundService.getRefundFee(order), is(this.refundFee));
    }
}

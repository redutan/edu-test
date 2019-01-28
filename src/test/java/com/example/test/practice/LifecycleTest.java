package com.example.test.practice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author myeongju.jung
 */
public class LifecycleTest {

    @BeforeClass
    public static void setUpOnlyOnce() {
        System.out.println("setUpOnlyOnce");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @AfterClass
    public static void tearDownOnlyOnce() {
        System.out.println("tearDownOnlyOnce");
    }
}

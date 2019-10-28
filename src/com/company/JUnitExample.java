package com.company;

import org.junit.*;

public class JUnitExample {

    @BeforeClass
    public static void setUpBeforeClass(){
        System.out.println("Executing before class lalalala");
    }

    @AfterClass
    public static void setUpAfterClass(){
        System.out.println("Executing after class lalalala");
    }

    @Before
    public void setUp(){
        System.out.println("Executing setUp lalalala");
    }

    @After
    public void tearDown(){
        System.out.println("Executing tearDown lalalala");
    }

    @Test
    public void test1(){
        System.out.println("Executing test1 lalalala");
    }

    @Test
    public void test2(){
        System.out.println("Executing test2 lalalala");
    }
}

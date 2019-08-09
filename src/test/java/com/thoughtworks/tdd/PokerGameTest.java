package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerGameTest {

    @Test
    public static void should_return_3H_when_call_compare_given_3H_2D(){
        String result = PokerGame.compareTwoPoker("3H","2D");
        Assertions.assertEquals("3H",result);
    }


}
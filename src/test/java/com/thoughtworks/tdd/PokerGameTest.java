package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PokerGameTest {

    @Test
    public  void should_return_3H_when_call_compare_given_3H_2D(){
        //given
        Poker poker1 = new Poker("3H");
        Poker poker2 = new Poker("2D");

        //when
        String result = PokerGame.compareTwoPoker(poker1,poker2);

        //then
        Assertions.assertEquals("poker1",result);
    }


}
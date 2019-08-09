package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class PokerGameTest {

    @Test
    public void should_return_poker1_when_call_compare_given_3H_2D() {
        //given
        Poker poker1 = new Poker("3H");
        List<Poker> player1PokerList =new ArrayList<>();
        player1PokerList.add(poker1);

        Poker poker2 = new Poker("2D");
        List<Poker> player2PokerList =new ArrayList<>();
        player2PokerList.add(poker2);
        //when
        String result = PokerGame.compareTwoPoker(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("poker1", result);
    }

    @Test
    public void should_return_player1_wins_when_call_compare_given_3H_3D_VS_4H_5C() {
        //given
        List<Poker> player1PokerList =new ArrayList<>();
        player1PokerList.add(new Poker("3H"));
        player1PokerList.add(new Poker("3D"));

        List<Poker> player2PokerList =new ArrayList<>();
        player2PokerList.add(new Poker("4H"));
        player2PokerList.add(new Poker("5D"));


        //when
        String result = PokerGame.compareTwoPoker(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("player1 wins", result);
    }


}
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
        String result = PokerGame.compareTwoPlayers(player1PokerList, player2PokerList);

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
        String result = PokerGame.compareTwoPlayers(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("player1 wins", result);
    }

    @Test
    public void should_return_equals_when_call_compare_given_4H_2D_VS_4C_3C() {
        //given
        List<Poker> player1PokerList =new ArrayList<>();
        player1PokerList.add(new Poker("4H"));
        player1PokerList.add(new Poker("2D"));

        List<Poker> player2PokerList =new ArrayList<>();
        player2PokerList.add(new Poker("4C"));
        player2PokerList.add(new Poker("3C"));

        //when
        String result = PokerGame.compareTwoPlayers(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("equals", result);
    }

    @Test
    public void should_return_player2_wins_given_2H_3D_4S_JC_QS_VS_5H_6C_9H_10D_AS(){
        //given
        List<Poker> player1PokerList =new ArrayList<>();
        player1PokerList.add(new Poker("2H"));
        player1PokerList.add(new Poker("3D"));
        player1PokerList.add(new Poker("4S"));
        player1PokerList.add(new Poker("JC"));
        player1PokerList.add(new Poker("QS"));

        List<Poker> player2PokerList =new ArrayList<>();
        player2PokerList.add(new Poker("5H"));
        player2PokerList.add(new Poker("6C"));
        player2PokerList.add(new Poker("9H"));
        player2PokerList.add(new Poker("10D"));
        player2PokerList.add(new Poker("AS"));

        //when
        String result = PokerGame.compareTwoPlayers(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("player2 wins", result);
    }

    @Test
    public void should_return_equals_given_2H_3D_4S_6C_AD_VS_5H_6C_9H_10D_AS(){
        //given
        List<Poker> player1PokerList =new ArrayList<>();
        player1PokerList.add(new Poker("2H"));
        player1PokerList.add(new Poker("3D"));
        player1PokerList.add(new Poker("4S"));
        player1PokerList.add(new Poker("6C"));
        player1PokerList.add(new Poker("AD"));

        List<Poker> player2PokerList =new ArrayList<>();
        player2PokerList.add(new Poker("5H"));
        player2PokerList.add(new Poker("6C"));
        player2PokerList.add(new Poker("9H"));
        player2PokerList.add(new Poker("10D"));
        player2PokerList.add(new Poker("AS"));
        //when
        String result = PokerGame.compareTwoPlayers(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("equals", result);
    }

    @Test
    public void should_return_player1_wins_given_2H_2D_4S_6C_KD_VS_5H_6C_9H_10D_AS(){
        //given
        List<Poker> player1PokerList =new ArrayList<>();
        player1PokerList.add(new Poker("2H"));
        player1PokerList.add(new Poker("2D"));
        player1PokerList.add(new Poker("4S"));
        player1PokerList.add(new Poker("6C"));
        player1PokerList.add(new Poker("KD"));

        List<Poker> player2PokerList =new ArrayList<>();
        player2PokerList.add(new Poker("5H"));
        player2PokerList.add(new Poker("6C"));
        player2PokerList.add(new Poker("9H"));
        player2PokerList.add(new Poker("10D"));
        player2PokerList.add(new Poker("AS"));
        //when
        String result = PokerGame.compareTwoPlayers(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("player1 wins", result);
    }

    @Test
    public void should_return_player2_wins_given_3H_3D_4S_6C_KD_VS_2H_2C_9H_10D_AS(){
        //given
        List<Poker> player1PokerList =new ArrayList<>();
        player1PokerList.add(new Poker("2H"));
        player1PokerList.add(new Poker("2D"));
        player1PokerList.add(new Poker("4S"));
        player1PokerList.add(new Poker("6C"));
        player1PokerList.add(new Poker("KD"));

        List<Poker> player2PokerList =new ArrayList<>();
        player2PokerList.add(new Poker("3H"));
        player2PokerList.add(new Poker("3C"));
        player2PokerList.add(new Poker("9H"));
        player2PokerList.add(new Poker("10D"));
        player2PokerList.add(new Poker("JS"));
        //when
        String result = PokerGame.compareTwoPlayers(player1PokerList, player2PokerList);

        //then
        Assertions.assertEquals("player2 wins", result);
    }



}
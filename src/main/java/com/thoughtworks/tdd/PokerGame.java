package com.thoughtworks.tdd;

import java.util.Arrays;

public class PokerGame {



    private static final String POKER_LIST []= new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public static String compareTwoPoker(Poker poker1, Poker poker2) {
        String result = null;
        if(poker1.getValue().equals(poker2.getValue()))
            result = "equals";
        else {
            result =  Arrays.asList(POKER_LIST).indexOf(poker1.getValue()) > Arrays.asList(POKER_LIST).indexOf(poker2.getValue()) ? "poker1" : "poker2";
        }
        return result;
    }
}

package com.thoughtworks.tdd;

import java.util.Arrays;
import java.util.List;

public class PokerGame {



    private static final String POKER_LIST []= new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public static String compareTwoPoker(List<Poker> poker1, List<Poker> poker2) {
        String result = null;
        if(poker1.get(0).getValue().equals(poker2.get(0).getValue()))
            result = "equals";
        else {
            result =  Arrays.asList(POKER_LIST).indexOf(poker1.get(0).getValue()) > Arrays.asList(POKER_LIST).indexOf(poker2.get(0).getValue()) ? "poker1" : "poker2";
        }
        return result;
    }
}

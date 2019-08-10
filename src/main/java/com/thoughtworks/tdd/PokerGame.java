package com.thoughtworks.tdd;

import java.util.Arrays;
import java.util.List;

public class PokerGame {

    public static final List<String> POKER_LIST = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A");

    public static String compareTwoPoker(Poker poker1, Poker poker2) {
        return poker1.getValue().equals(poker2.getValue()) ? "equals" :
                (POKER_LIST.indexOf(poker1.getValue()) > POKER_LIST.indexOf(poker2.getValue()) ? "poker1" : "poker2");
    }

    public static String compareTwoPokerList(List<Poker> pokerList1, List<Poker> pokerList2) {
        return PokerCompare.compare(pokerList1,pokerList2);
    }


    public static String compareTwoPlayers(List<Poker> pokerList1, List<Poker> pokerList2){
        if(pokerList1.size() == 1 ){
            return  compareTwoPoker(pokerList1.get(0),pokerList2.get(0));
        }
        return compareTwoPokerList(pokerList1,pokerList2);
    }
}

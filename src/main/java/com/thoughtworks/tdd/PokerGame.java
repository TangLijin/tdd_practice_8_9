package com.thoughtworks.tdd;

import java.util.Arrays;
import java.util.List;

public class PokerGame {



    private static final String POKER_LIST []= new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public static String compareTwoPoker(List<Poker> pokerList1, List<Poker> pokerList2) {

        String result = null;
        if(pokerList1.size() == 1){
            if(pokerList1.get(0).getValue().equals(pokerList2.get(0).getValue()))
                result = "equals";
            else {
                result = Arrays.asList(POKER_LIST).indexOf(pokerList1.get(0).getValue()) > Arrays.asList(POKER_LIST).indexOf(pokerList2.get(0).getValue()) ? "poker1" : "poker2";
            }
        }else {
            if(pokerList1.get(0).getValue().equals(pokerList1.get(1).getValue())&& pokerList2.get(0).getValue().equals(pokerList2.get(1).getValue())){
                result = Arrays.asList(POKER_LIST).indexOf(pokerList1.get(0).getValue()) > Arrays.asList(POKER_LIST).indexOf(pokerList2.get(0).getValue()) ? "player1 wins" : "player2 wins";
            }else if(pokerList1.get(0).getValue().equals(pokerList1.get(1).getValue())){
                result = "player1 wins";
            }else if(pokerList2.get(0).getValue().equals(pokerList2.get(1).getValue())){
                result = "player2 wins";
            }else {
                int maxIndex1 = Arrays.asList(POKER_LIST).indexOf(pokerList1.get(0).getValue()) > Arrays.asList(POKER_LIST).indexOf(pokerList1.get(1).getValue()) ?
                        Arrays.asList(POKER_LIST).indexOf(pokerList1.get(0).getValue()) : Arrays.asList(POKER_LIST).indexOf(pokerList1.get(1).getValue());
                int maxIndex2 = Arrays.asList(POKER_LIST).indexOf(pokerList2.get(0).getValue()) > Arrays.asList(POKER_LIST).indexOf(pokerList2.get(1).getValue()) ?
                        Arrays.asList(POKER_LIST).indexOf(pokerList2.get(0).getValue()) : Arrays.asList(POKER_LIST).indexOf(pokerList2.get(1).getValue());
                if(maxIndex1 == maxIndex2){
                    result = "equals";
                }else{
                    result = maxIndex1 > maxIndex2 ? "player1 wins" : "player2 wins";
                }

            }

        }

        return result;
    }
}

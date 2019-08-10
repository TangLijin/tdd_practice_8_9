package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerGame {

    //    private static final String POKER_LIST1 []= new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
//    private static final ArrayList<String> POKER_LIST = (ArrayList<String>) Arrays.asList(POKER_LIST1);
    private static final List<String> POKER_LIST = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A");

    public static List<Poker> sortPorks(List<Poker> pokerList){
        List<Poker> sortedPorkrList = new ArrayList<>();
        if(pokerList.size() > 1){
            for(String pokerValue : POKER_LIST){
                for(Poker poker : pokerList){
                    if(poker.getValue().equals(pokerValue)){
                        sortedPorkrList.add(poker);
                    }
                }
            }
        }
        return sortedPorkrList;
    }

    public static Boolean ifContainEqualValuePoker(List<Poker> pokerList){
        for(int i = 0; i < pokerList.size() - 1 ; i++){
            for(int j = i + 1; j < pokerList.size(); j++){
                if(pokerList.get(i).getValue().equals(pokerList.get(j).getValue())){
                    return true;
                }
            }
        }
        return false;
    }

    public static String compareTwoPoker(Poker poker1, Poker poker2) {
        return poker1.getValue().equals(poker2.getValue()) ? "equals" :
                (POKER_LIST.indexOf(poker1.getValue()) > POKER_LIST.indexOf(poker2.getValue()) ? "poker1" : "poker2");
    }

    public static String compareTwoPokerList(List<Poker> pokerList1, List<Poker> pokerList2) {
        String result = null;
        List<Poker> sortedPorkrList1 = sortPorks(pokerList1);
        List<Poker> sortedPorkrList2 = sortPorks(pokerList2);
        System.out.println(sortedPorkrList1);
        System.out.println(sortedPorkrList2);


        if(ifContainEqualValuePoker(pokerList1)){
            result = "player1 wins";
        }else if(ifContainEqualValuePoker(pokerList2)){
            result = "player2 wins";
        }else {
            result = POKER_LIST.indexOf(sortedPorkrList1.get(sortedPorkrList1.size() - 1).getValue()) ==
                    POKER_LIST.indexOf(sortedPorkrList2.get(sortedPorkrList2.size() - 1).getValue()) ?
                    "equals" : (POKER_LIST.indexOf(sortedPorkrList1.get(sortedPorkrList1.size() - 1).getValue()) >
                    POKER_LIST.indexOf(sortedPorkrList2.get(sortedPorkrList2.size() - 1).getValue()) ? "player1 wins" : "player2 wins");
        }

//        if (pokerList1.get(0).getValue().equals(pokerList1.get(1).getValue()) && pokerList2.get(0).getValue().equals(pokerList2.get(1).getValue())) {
//            result = POKER_LIST.indexOf(pokerList1.get(0).getValue()) > POKER_LIST.indexOf(pokerList2.get(0).getValue()) ? "player1 wins" : "player2 wins";
//        } else if (pokerList1.get(0).getValue().equals(pokerList1.get(1).getValue())) {
//            result = "player1 wins";
//        } else if (pokerList2.get(0).getValue().equals(pokerList2.get(1).getValue())) {
//            result = "player2 wins";
//        }else{
//            result = POKER_LIST.indexOf(sortedPorkrList1.get(1).getValue()) == POKER_LIST.indexOf(sortedPorkrList2.get(1).getValue()) ?
//                    "equals" :
//                    (POKER_LIST.indexOf(sortedPorkrList1.get(1).getValue()) > POKER_LIST.indexOf(sortedPorkrList2.get(1).getValue()) ?
//                    "player1 wins" : "player2 wins");
//        }
        return result;
    }


    public static String compareTwoPlayers(List<Poker> pokerList1, List<Poker> pokerList2){
        if(pokerList1.size() == 1 ){
            return  compareTwoPoker(pokerList1.get(0),pokerList2.get(0));
        }
        return compareTwoPokerList(pokerList1,pokerList2);
    }
}

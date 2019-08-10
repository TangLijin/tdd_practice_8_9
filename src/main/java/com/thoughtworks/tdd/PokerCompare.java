package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class PokerCompare {

    public static List<Poker> sortPorks(List<Poker> pokerList) {
        List<Poker> sortedPorkrList = new ArrayList<>();
        if (pokerList.size() > 1) {
            for (String pokerValue : PokerGame.POKER_LIST) {
                for (Poker poker : pokerList) {
                    if (poker.getValue().equals(pokerValue)) {
                        sortedPorkrList.add(poker);
                    }
                }
            }
        }
        return sortedPorkrList;
    }

    public static Boolean ifContainEqualValuePoker(List<Poker> pokerList) {
        for (int i = 0; i < pokerList.size() - 1; i++) {
            for (int j = i + 1; j < pokerList.size(); j++) {
                if (pokerList.get(i).getValue().equals(pokerList.get(j).getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    //是否包含两对相等的牌
    public static Boolean ifContainTwoPairEqualValuePokers(List<Poker> pokerList) {
        int equalValuePokerCount = 0;
        String lastEqualPair = null; //记录上一对相等的value
        List<Poker> sortedPokerList = sortPorks(pokerList);
        for (int i = 0; i < pokerList.size() - 1; i++) {
            if (pokerList.get(i).getValue().equals(pokerList.get(i + 1).getValue()) && !(pokerList.get(i).getValue().equals(lastEqualPair))) {
                equalValuePokerCount++;
                lastEqualPair = pokerList.get(i).getValue();
            }
        }
        return (equalValuePokerCount == 2 ? true : false);
    }

    public static Poker getEqualValuePoker(List<Poker> pokerList) {
        for (int i = 0; i < pokerList.size() - 1; i++) {
            for (int j = i + 1; j < pokerList.size(); j++) {
                if (pokerList.get(i).getValue().equals(pokerList.get(j).getValue())) {
                    return pokerList.get(i);
                }
            }
        }
        return null;
    }

    public static int getPokerRank(List<Poker> pokerList) {
        int rank = 1;
        if(ifContainEqualValuePoker(pokerList)) {
            rank = 2;
        }
        if(ifContainTwoPairEqualValuePokers(pokerList)) {
            rank = 3;
        }
        if(ifContainThreeEqualValuePokers(pokerList)){
            rank = 4;
        }
//        if(ifAllContinuous(pokerList)){
//            rank = 5;
//        }

        return rank;
    }

//    private static boolean ifAllContinuous(List<Poker> pokerList) {
//        List<Integer> indexList = new ArrayList<>();
//        for (Poker poker : pokerList){
//            indexList.add(PokerGame.POKER_LIST.indexOf(poker.getValue()));
//        }
//        for(int i = 0; i < indexList.size() - 1; i++){
//            if(indexList.get(i + 1) - indexList.get(i) != 1){
//                return false;
//            }
//        }
//        return true;
//    }

    private static boolean ifContainThreeEqualValuePokers(List<Poker> pokerList) {
        if (pokerList.size() >= 3) {
            for (int i = 0; i < pokerList.size() - 2; i++) {
                if (pokerList.get(i).getValue().equals(pokerList.get(i + 1).getValue()) &&
                        pokerList.get(i + 1).getValue().equals(pokerList.get(i + 2).getValue())
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String dealEqualRankPokerList(List<Poker> pokerList1, List<Poker> pokerList2, int rank) {
        String result = null;
        switch (rank) {
            case 1: //直接比较最大元素
                result = PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) ==
                        PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue()) ?
                        "equals" : (PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) >
                        PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue()) ? "player1 wins" : "player2 wins");
                break;
            case 2://先比较对子，再比较最大单值
            case 4: //先比较相同的牌，再比较最大单值,和2的处理相同
                if (PokerGame.POKER_LIST.indexOf(getEqualValuePoker(pokerList1).getValue()) ==
                        PokerGame.POKER_LIST.indexOf(getEqualValuePoker(pokerList2).getValue())) {
                    if (PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) ==
                            PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue())) {
                        result = "equals";
                    } else {
                        result = PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) >
                                PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue()) ? "player1 wins" : "player2 wins";
                    }
                } else {
                    result = PokerGame.POKER_LIST.indexOf(getEqualValuePoker(pokerList1).getValue()) ==
                            PokerGame.POKER_LIST.indexOf(getEqualValuePoker(pokerList2).getValue()) ?
                            "equals" : (PokerGame.POKER_LIST.indexOf(getEqualValuePoker(pokerList1).getValue()) >
                            PokerGame.POKER_LIST.indexOf(getEqualValuePoker(pokerList2).getValue()) ? "player1 wins" : "player2 wins");
                }
                break;
            case 3://直接比较最大单值
                result = PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) ==
                        PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue()) ?
                        "equals" : (PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) >
                        PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue()) ? "player1 wins" : "player2 wins");
                break;

        }
        return result;

    }

    public static String compare(List<Poker> pokerList1, List<Poker> pokerList2) {
        String result = null;
        List<Poker> sortedPokerList1 = sortPorks(pokerList1);
        List<Poker> sortedPokerList2 = sortPorks(pokerList2);
        if (getPokerRank(sortedPokerList1) > getPokerRank(sortedPokerList2)) {
            result = "player1 wins";
        } else if (getPokerRank(sortedPokerList1) < getPokerRank(sortedPokerList2)) {
            result = "player2 wins";
        } else {
            result = dealEqualRankPokerList(sortedPokerList1,sortedPokerList2,getPokerRank(sortedPokerList1));
        }

        return result;
    }

}

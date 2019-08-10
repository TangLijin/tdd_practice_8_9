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

    public static Boolean ifContainTwoEqualValuePoker(List<Poker> pokerList) {  //只判断两个值相等的情况，三个值相等的情况不满足
        if(pokerList.size() <= 2){
            return pokerList.get(0).getValue().equals(pokerList.get(1).getValue());
        }else {
            String lastEqualValue = null; //记录上一对相等的value
            for (int i = 0; i < pokerList.size() - 2; i++) {
                if (pokerList.get(i).getValue().equals(pokerList.get(i + 1).getValue())){
                    if(pokerList.get(i + 1).getValue().equals(pokerList.get(i + 2).getValue())){
                        i++;
                        continue;
                    } else {
                        return true;
                    }
                }
            }
            if(pokerList.get(pokerList.size() - 2).getValue().equals(pokerList.get(pokerList.size() - 1).getValue())){
                return true;
            }
            return false;
        }

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
        if(ifContainTwoEqualValuePoker(pokerList)) { //一对相同值
            rank = 2;
        }
        if(ifContainTwoPairEqualValuePokers(pokerList)) {//两对相同值
            rank = 3;
        }
        if(ifContainThreeEqualValuePokers(pokerList)){ //3个相同值
            rank = 4;
        }
        if(ifAllContinuous(pokerList)){ //普通顺子
            rank = 5;
        }
        if(ifSameType(pokerList)){  //同花色
            rank = 6;
        }
        if(ifExist3XAnd2Y(pokerList)){  //
            rank = 7;
        }
        if(ifContainFourEqualValuePokers(pokerList)){ //4个相同值
            rank = 8;
        }
        if(ifSameType(pokerList)&& ifAllContinuous(pokerList)){ //同花顺
            rank = 9;
        }
        return rank;
    }

    private static boolean ifContainFourEqualValuePokers(List<Poker> pokerList) {
        if (pokerList.size() >= 4) {
            for (int i = 0; i < pokerList.size() - 3; i++) {
                if (pokerList.get(i).getValue().equals(pokerList.get(i + 1).getValue()) &&
                        pokerList.get(i + 1).getValue().equals(pokerList.get(i + 2).getValue()) &&
                                pokerList.get(i + 2).getValue().equals(pokerList.get(i + 3).getValue())
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean ifExist3XAnd2Y(List<Poker> pokerList) {
        if(ifContainThreeEqualValuePokers(pokerList) && ifContainTwoEqualValuePoker(pokerList)){
            return true;
        }
        return false;
    }

    private static boolean ifSameType(List<Poker> pokerList) {
        if(pokerList.size() < 3 )
            return false;
        List<Character> typeList = new ArrayList<>();
        for (Poker poker : pokerList){
            typeList.add(poker.getType());
        }
        for(int i = 0; i < typeList.size() - 1; i++){
            if(typeList.get(i + 1) != typeList.get(i) ){
                return false;
            }
        }
        return true;
    }

    private static boolean ifAllContinuous(List<Poker> pokerList) {
        if(pokerList.size() < 3 )
            return false;
        List<Integer> indexList = new ArrayList<>();
        for (Poker poker : pokerList){
            indexList.add(PokerGame.POKER_LIST.indexOf(poker.getValue()));
        }
        for(int i = 0; i < indexList.size() - 1; i++){
            if(indexList.get(i + 1) - indexList.get(i) != 1){
                return false;
            }
        }
        return true;
    }

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
            case 5:
            case 6:
            case 9:
                result = PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) ==
                        PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue()) ?
                        "equals" : (PokerGame.POKER_LIST.indexOf(pokerList1.get(pokerList1.size() - 1).getValue()) >
                        PokerGame.POKER_LIST.indexOf(pokerList2.get(pokerList2.size() - 1).getValue()) ? "player1 wins" : "player2 wins");
                break;
            case 2://先比较对子，再比较最大单值
            case 4: //先比较相同的牌，再比较最大单值,和2的处理相同
            case 8:
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

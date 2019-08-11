package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class PokerListUtils {

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
            for (int i = 0; i < pokerList.size() - 2; i++) {
                if (pokerList.get(i).getValue().equals(pokerList.get(i + 1).getValue())){
                    if(pokerList.get(i + 1).getValue().equals(pokerList.get(i + 2).getValue())){
                        i++;
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

    public static boolean ifExist3XAnd2Y(List<Poker> pokerList) {
        if(ifContainThreeEqualValuePokers(pokerList) && ifContainTwoEqualValuePoker(pokerList)){
            return true;
        }
        return false;
    }

    public static boolean ifSameType(List<Poker> pokerList) {
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

    public static boolean ifAllContinuous(List<Poker> pokerList) {
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

    public static boolean ifContainThreeEqualValuePokers(List<Poker> pokerList) {
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

    public static boolean ifContainFourEqualValuePokers(List<Poker> pokerList) {
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



}

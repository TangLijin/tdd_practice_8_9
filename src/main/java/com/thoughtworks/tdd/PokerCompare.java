package com.thoughtworks.tdd;

import java.util.List;

import static com.thoughtworks.tdd.PokerListUtils.*;

public class PokerCompare {




    public static int getPokerRank(List<Poker> pokerList) {
        int rank = 1;
        if(PokerListUtils.ifContainTwoEqualValuePoker(pokerList)) { //一对相同值
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

    public static String dealEqualRankPokerList(List<Poker> pokerList1, List<Poker> pokerList2, int rank) {
        String result = null;
        switch (rank) {
            case 1: //直接比较最大元素
            case 5:
            case 6:
            case 9:
            case 3://直接比较最大单值
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

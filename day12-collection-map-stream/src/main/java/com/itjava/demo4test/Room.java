package com.itjava.demo4test;

import java.util.*;

public class Room {

    //准备54张牌
    private String[] sizes = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    private String[] colors = {"♠", "♥", "♣", "♦"};
    List<Card> cards = new ArrayList<>();

    {
        //把这些放到一个集合中
        int level = 0;
        for (String size : sizes) {
            for (String color : colors) {
                Card card = new Card(size, color,level);
                cards.add(card);
            }
            level++;
        }
        Collections.addAll(cards, new Card("", "小王",++level), new Card("", "大王",++level));
    }

    public void startGame() {
        //展示所有的牌
        System.out.println(cards);
        System.out.println(cards.size());

        //打乱牌序
        Collections.shuffle(cards);
        System.out.println(cards);

        //准备三个玩家play1 play2 play3
        //玩家和牌可以当作是一对键值对，所有用Map集合
        Map<String, List<Card>> plays = new HashMap<>();
        List<Card> play1Cards = new ArrayList<>();
        List<Card> play2Cards = new ArrayList<>();
        List<Card> play3Cards = new ArrayList<>();
        plays.put("play1", play1Cards);
        plays.put("play2", play2Cards);
        plays.put("play3", play3Cards);
        //发牌  发51张牌，剩下3张作为地主牌
        for (int i = 0; i < 51; i++) {
            Card card = cards.get(i);  //集合取值要用get
            if (i % 3 == 0) {
                play1Cards.add(card);
            } else if (i % 3 == 1) {
                play2Cards.add(card);
            } else {
                play3Cards.add(card);
            }
        }
        //拿最后三张牌，梵高一个集合中              开始索引            结束索引
        List<Card> lastCards = cards.subList(cards.size() - 3, cards.size());
        //把这个集合随机给一个人
        int r = (int) (Math.random() * plays.size());
        System.out.println(r);
        switch (r) {
            case 0 -> play1Cards.addAll(lastCards);
            case 1 -> play2Cards.addAll(lastCards);
            case 2 -> play3Cards.addAll(lastCards);
        }

        //给各自卡牌排序  根据卡牌等级排序
        sortCards(play1Cards);
        sortCards(play2Cards);
        sortCards(play3Cards);


        //展示各自的手牌
//        System.out.println(plays);
        for (Map.Entry<String, List<Card>> play : plays.entrySet()) {
            System.out.println(play);
        }

    }

    private void sortCards(List<Card> playCards) {
        /*
        Collections.sort(playCards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getLevel()-o2.getLevel();
            }
        });
        */

        Collections.sort(playCards,((o1, o2) -> o1.getLevel()- o2.getLevel()));
    }

}

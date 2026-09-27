package com.itjava.demo4test;

public class Game {
    public static void main(String[] args) {
        //斗地主游戏
/*        分析业务需求
        总共有54张牌
        点数: "3","4","5","6","7","8","9","10","J","Q","K","A","2"
        花色: "♠","♥","♣","♦"
        大小王: "🃏","🃏"
        斗地主: 发出51张牌，剩下3张做为底牌。

        分析实现
        在启动游戏房间的时候，应该提前准备好54张牌
        接着，需要完成洗牌、发牌、对牌排序、看牌*/

        //开始游戏
        Room room = new Room();
        room.startGame();
    }
}

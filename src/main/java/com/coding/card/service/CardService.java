package com.coding.card.service;

import com.coding.card.Card;

/**
 * 卡信息服务类
 * @author gaohaoliang
 */
public class CardService {
    /**
     * 普卡与金卡分界值
     */
    private static final int CommonCardPoint = 10000;
    /**
     * 金卡与白金卡分界值
     */
    private static final int GoldCardPoint = 50000;
    /**
     * 白金卡与钻石卡分界值
     */
    private static final int PlatinumCardPoint = 100000;

    private static final String CommonCard = "普卡";
    private static final String GoldCard = "金卡";
    private static final String PlatinumCard = "白金卡";
    private static final String DiamondCard = "钻石卡";

    /**
     * 根据客户级别获取卡信息
     * @param memberLevel
     * @return
     */
    public Card getCardInfoByCardType(String memberLevel){
        if(CommonCard.equals(memberLevel)){
            return getCommonCardInfo();
        }else if(GoldCard.equals(memberLevel)){
            return getGoldCardInfo();
        }else if(PlatinumCard.equals(memberLevel)){
            return getPlatinumCardInfo();
        }else if(DiamondCard.equals(memberLevel)){
            return getDiamondCardInfo();
        }else{
            return getCommonCardInfo();
        }
    }

    /**
     * 根据积分获取卡信息
     * @param point
     * @return
     * @throws Exception
     */
    public Card getCardInfoByPoint(int point) throws Exception {
        if(point < CommonCardPoint){
            return getCommonCardInfo();
        }else if(point < GoldCardPoint){
            return getGoldCardInfo();
        }else if(point < PlatinumCardPoint){
            return getPlatinumCardInfo();
        }else {
            return getDiamondCardInfo();
        }
    }

    /**
     * 获取普通卡信息
     * @return
     */
    private Card getCommonCardInfo(){
        Card card = new Card();
        card.setCardType("普卡");
        card.setPointTimes(1);
        return card;
    }

    /**
     * 获取金卡信息
     * @return
     */
    private Card getGoldCardInfo(){
        Card card = new Card();
        card.setCardType("金卡");
        card.setPointTimes(1.5);
        return card;
    }

    /**
     * 获取白金卡信息
     * @return
     */
    private Card getPlatinumCardInfo(){
        Card card = new Card();
        card.setCardType("白金卡");
        card.setPointTimes(1.8);
        return card;
    }

    /**
     * 获取钻石卡信息
     * @return
     */
    private Card getDiamondCardInfo(){
        Card card = new Card();
        card.setCardType("钻石卡");
        card.setPointTimes(2);
        return card;
    }

}

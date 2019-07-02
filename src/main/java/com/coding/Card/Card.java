package com.coding.Card;

/**
 * 卡信息实体类
 * @author gaohaoliang
 */
public class Card {
    /**
     * 卡类型
     */
    private String cardType;
    /**
     * 积分基准倍数
     */
    private String pointTimes;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getPointTimes() {
        return pointTimes;
    }

    public void setPointTimes(String pointTimes) {
        this.pointTimes = pointTimes;
    }
}

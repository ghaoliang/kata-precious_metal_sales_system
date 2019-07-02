package com.coding.card;

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
    private double pointTimes;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getPointTimes() {
        return pointTimes;
    }

    public void setPointTimes(double pointTimes) {
        this.pointTimes = pointTimes;
    }
}

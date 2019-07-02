package com.coding.card;

import java.math.BigDecimal;

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
    private BigDecimal pointTimes;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

	public BigDecimal getPointTimes() {
		return pointTimes;
	}

	public void setPointTimes(BigDecimal pointTimes) {
		this.pointTimes = pointTimes;
	}

}

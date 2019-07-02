package com.coding.sales.service;

import java.math.BigDecimal;

import com.coding.card.Card;
import com.coding.card.service.CardService;
import com.coding.member.Member;
import com.coding.utils.Constants;

/**
 * 产品购买业务实现
 * @author yeyam
 *
 */
public class BuyProductService {
	
	public CardService cardService = new CardService();
	/**
	 * 根据客户卡信息及支付金额获取新增积分
	 * @param member
	 * @param money
	 * @return
	 */
	public Integer getIncreasePointByProductAndCustLevel(Member member,BigDecimal money){
		if(member == null || money == null){
			return 0;
		};
		Card card = cardService.getCardInfoByCardType(member.getMemberLevel());
		BigDecimal pointTimes = card.getPointTimes();
		BigDecimal increasePoint = money.multiply(pointTimes).setScale(0);
		return increasePoint.intValue();
	}
	
}

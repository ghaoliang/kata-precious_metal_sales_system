package com.coding.sales.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.coding.member.Member;
import com.coding.member.service.MemberService;

public class BuyProductServiceTest {

	@Test
	public void getCustIncreasePointTest(){
		MemberService memberService = new MemberService();
		BuyProductService buyProductService = new BuyProductService();
		Member member = memberService.getMemberInfoByMemberId("6630009999");
		BigDecimal money = new BigDecimal((Double)1000.00);
		int increasePoit = buyProductService.getIncreasePointByProductAndCustLevel(member, money);
		assertEquals(1500,increasePoit);
	}
}

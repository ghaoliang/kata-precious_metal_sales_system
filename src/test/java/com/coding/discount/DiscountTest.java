package com.coding.discount;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 打折卷实体
 * @author yeyam
 *
 */
public class DiscountTest {
	
	@Test
	public void getDiscountTest(){
		List<String> discountList = new ArrayList<String>();
		discountList.add("95折券");
		discountList.add("9折券");
		Discount discount = new Discount();
		assertEquals("95折券",(discount.getDiscountList(discountList)).get(0));
		assertEquals("9折券",(discount.getDiscountList(discountList)).get(1));
	}
	

}

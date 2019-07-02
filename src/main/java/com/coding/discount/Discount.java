package com.coding.discount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.utils.Constants;

/**
 * 打折卷实体
 * @author yeyam
 *
 */
public class Discount {
	
	public final static Map<String,String> discountMap = new HashMap<String,String>();
	static{
		discountMap.put("95折券", Constants.DISCOUNT_95);
		discountMap.put("9折券", Constants.DISCOUNT_9);
	}
	
	public List<String> getDiscountList(List<String> discountParam){
		List<String> discountList = new ArrayList<String>();
		for(String discount:discountParam){
			discountList.add(discountMap.get(discount));			
		}
		return discountList;
	}
}

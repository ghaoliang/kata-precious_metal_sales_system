package com.coding.discount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 打折卷实体
 * @author yeyam
 *
 */
public class Discount {
	
	public final static Map<String,Double> discountMap = new HashMap<String,Double>();
	static{
		discountMap.put("95折券", 0.95);
		discountMap.put("9折券", 0.90);
	}
	
	public List<Double> getDiscountList(List<String> discountParam){
		List<Double> discountList = new ArrayList<Double>();
		for(String discount:discountParam){
			discountList.add(discountMap.get(discount));			
		}
		return discountList;
	}
}

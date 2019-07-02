package com.coding.activity.service;

import com.coding.product.Product;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.utils.Constants;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开门红活动服务类
 * @author gaohaoliang
 */
public class GoodStartActivityService {
    public final static Map<String,BigDecimal> discountMap = new HashMap<String,BigDecimal>();
    static{
        discountMap.put(Constants.DISCOUNT_95,new BigDecimal(0.95));
        discountMap.put(Constants.DISCOUNT_9, new BigDecimal(0.90));
    }


    /**
     * 获取折扣金额
     * @param orderItemRepresentation
     * @param product
     * @param discountList
     * @return
     */
    public BigDecimal getDiscountMoney(OrderItemRepresentation orderItemRepresentation, Product product, List<String> discountList){
        BigDecimal discountMoney = new BigDecimal(0);
        if(discountList.contains(product.getDiscount())){
            discountMoney = orderItemRepresentation.getSubTotal().multiply(new BigDecimal(1).subtract(discountMap.get(product.getDiscount())));
        }

        if(product.getFullPurchase() != null && product.getFullPurchase().length > 0){
            BigDecimal fullPurchaseMoney = getDiscountMoneyByFullPurchase(orderItemRepresentation,product.getFullPurchase());
            discountMoney =  discountMoney.compareTo(fullPurchaseMoney) != -1 ? discountMoney : fullPurchaseMoney;
        }

        return discountMoney;
    }

    /**
     * 获取满减金额
     * @param orderItemRepresentation
     * @param fullPurchases
     * @return
     */
    public BigDecimal getDiscountMoneyByFullPurchase(OrderItemRepresentation orderItemRepresentation,String[] fullPurchases){
        BigDecimal totalPrice = orderItemRepresentation.getSubTotal();
        BigDecimal num = orderItemRepresentation.getAmount();
        BigDecimal discountMoney = new BigDecimal(0);
        for(String fullPurchase : fullPurchases){
            if(Constants.FULL_3000_PURCHASE_350.equals(fullPurchase) && totalPrice.compareTo(new BigDecimal(3000))!= -1){
                discountMoney = discountMoney.compareTo(new BigDecimal(350))!= -1 ? discountMoney : new BigDecimal(350);
            }else if(Constants.FULL_2000_PURCHASE_30.equals(fullPurchase) && totalPrice.compareTo(new BigDecimal(2000))!= -1){
                discountMoney = discountMoney.compareTo(new BigDecimal(30))!= -1 ? discountMoney : new BigDecimal(30);
            }else if(Constants.FULL_1000_PURCHASE_10.equals(fullPurchase) && totalPrice.compareTo(new BigDecimal(1000))!= -1){
                discountMoney = discountMoney.compareTo(new BigDecimal(10))!= -1 ? discountMoney : new BigDecimal(10);
            }else if(Constants.FULL_3_PURCHASE_HALF.equals(fullPurchase) && num.compareTo(new BigDecimal(3))!= -1){
                discountMoney = discountMoney.compareTo(totalPrice.divide(new BigDecimal(2))) != -1 ? discountMoney : totalPrice.divide(new BigDecimal(2));
            }else if(Constants.FULL_3_DELIVER_1.equals(fullPurchase) && num.compareTo(new BigDecimal(4))!= -1){
                discountMoney = discountMoney.compareTo(orderItemRepresentation.getPrice())!= -1 ? discountMoney : orderItemRepresentation.getPrice();
            }
        }
        return discountMoney;

    }
}

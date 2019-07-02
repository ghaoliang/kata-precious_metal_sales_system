package com.coding.order.service;

import com.coding.discount.Discount;
import com.coding.product.Product;
import com.coding.product.service.ProductService;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.utils.Constants;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.PaymentRepresentation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单处理服务类
 * @author ghaoliang
 */
public class OrderService {
	public final static Map<String,Double> discountMap = new HashMap<String,Double>();
	static{
		discountMap.put(Constants.DISCOUNT_95,0.95);
		discountMap.put(Constants.DISCOUNT_9, 0.90);
	}

    public List<OrderItemRepresentation> getOrderDetailInfo(List<OrderItemCommand> orderItemCommands ){
        ProductService productService = new ProductService();
        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();
        for(OrderItemCommand orderItemCommand : orderItemCommands){
            Product product = productService.getProductInfo(orderItemCommand.getProduct());
            OrderItemRepresentation orderItem = new OrderItemRepresentation(product.getProductId(),product.getProductName(),product.getPrice(),orderItemCommand.getAmount(),product.getPrice().multiply(orderItemCommand.getAmount()));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    /**
     * 根据订单明细获取订单总金额
     * @param orderItems
     * @return
     */
    public BigDecimal getOrderTotalPrice(List<OrderItemRepresentation> orderItems) {
        BigDecimal totalPrice = new BigDecimal(0);
        if(orderItems == null || orderItems.size() == 0){
            return totalPrice;
        }
        for(OrderItemRepresentation orderItemRepresentation : orderItems){
            totalPrice = totalPrice.add(orderItemRepresentation.getSubTotal());
        }
        return totalPrice;
    }

    /**
     * 获取支付记录
     * @param payments
     * @return
     */
    public List<PaymentRepresentation> getPaymentInfo(List<PaymentCommand> payments) {
        List<PaymentRepresentation> paymentList = new ArrayList<>();
        if(payments == null || payments.size() == 0){
            return  paymentList;
        }
        for(PaymentCommand paymentCommand : payments){
            PaymentRepresentation paymentRepresentation = new PaymentRepresentation(paymentCommand.getType(),paymentCommand.getAmount());
            paymentList.add(paymentRepresentation);
        }
        return paymentList;
    }
    
    public List<DiscountItemRepresentation> getDiscountItemList(List<OrderItemCommand> orderItemCommands,List<String> orderDiscountList){
        ProductService productService = new ProductService();
        List<DiscountItemRepresentation> discountItemList = new ArrayList<DiscountItemRepresentation>();
    	for(OrderItemCommand orderItemCommand:orderItemCommands){
    		Product product = productService.getProductInfo(orderItemCommand.getProduct());
    		String discount = product.getDiscount();
    		String fullPurchase[] = product.getFullPurchase();
    		Boolean is_discount = true;
    		Boolean is_fullPurchase = true;
    		DiscountItemRepresentation discountItem = null;
    		List<String> discountList = null;
    		Discount discount_entry = new Discount();
    		if(discount == null || "".equals(discount)){
    			is_discount = false;
    		}else{    			
    			discountList = discount_entry.getDiscountList(orderDiscountList);
    		};
    		if(fullPurchase == null || fullPurchase.length == 0){
    			is_fullPurchase = false;
    		};
    		if(is_discount && !is_fullPurchase && discountList.contains(product.getDiscount())){
    			BigDecimal discountMoney = product.getPrice().multiply(orderItemCommand.getAmount()).multiply(new BigDecimal(discountMap.get(product.getDiscount())));
    		}else if(!is_discount && is_fullPurchase){
    			
    		}else if(is_discount && is_fullPurchase){
    			
    		}else{
    			discountItem = new DiscountItemRepresentation(product.getProductId(), product.getProductName(), null);
    		}
    	};
    	return null;
    }

    /**
     * 获取优惠总金额
     * @param discount
     * @return
     */
    public BigDecimal getOrderDiscountPrice(List<DiscountItemRepresentation> discount) {
        BigDecimal totalDiscountPrice = new BigDecimal(0);
        if(discount == null || discount.size() == 0){
            return totalDiscountPrice;
        }
        for(DiscountItemRepresentation discountItemRepresentation : discount){
            totalDiscountPrice = totalDiscountPrice.add(discountItemRepresentation.getDiscount());
        }
        return totalDiscountPrice;
    }
}

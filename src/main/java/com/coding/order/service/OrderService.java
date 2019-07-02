package com.coding.order.service;

import com.coding.product.Product;
import com.coding.product.service.ProductService;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.output.OrderItemRepresentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单处理服务类
 * @author ghaoliang
 */
public class OrderService {

    /**
     * 获取订单明细清单
     * @param orderItemCommands
     * @return
     */
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
}

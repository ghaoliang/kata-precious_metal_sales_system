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


    public List<OrderItemRepresentation> getOrderDetailInfo(List<OrderItemCommand> orderItemCommands ){
        ProductService productService = new ProductService();
        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();
        for(OrderItemCommand orderItemCommand : orderItemCommands){
            Product product = productService.getProductInfo(orderItemCommand.getProduct());
        }
        return orderItems;
    }

    public BigDecimal getOrderTotalPrice(List<OrderItemRepresentation> orderItems) {
        //TODO 计算订单总金额
        return null;
    }
}

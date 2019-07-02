package com.coding.sales;

import com.coding.card.Card;
import com.coding.card.service.CardService;
import com.coding.member.Member;
import com.coding.member.service.MemberService;
import com.coding.order.service.OrderService;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String txtFileName = args[1];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);
        
        return result.toString();
    }

    OrderRepresentation checkout(OrderCommand command) {
        OrderRepresentation result = null;
        MemberService memberService = new MemberService();
        CardService cardService = new CardService();
        OrderService orderService = new OrderService();

        //获取用户信息
        Member member = memberService.getMemberInfoByMemberId(command.getMemberId());
        //获取当前用户卡信息
        Card card = cardService.getCardInfoByCardType(member.getMemberLevel());
        //获取本次消费新增积分
        int memberPointsIncreased = 0;
        //获取新增之后用户积分数
        int memberPoints = 0;
        //获取消费后用户卡信息
        Card finalCardInfo = cardService.getCardInfoByPoint(memberPoints);
        //获取订单明细
        List<OrderItemRepresentation> orderItems =  orderService.getOrderDetailInfo(command.getItems());
        //获取订单总金额
        BigDecimal totalPrice = orderService.getOrderTotalPrice(orderItems);
        //获取优惠明细
        List<DiscountItemRepresentation> discount = new ArrayList<>();
        //获取优惠总金额
        BigDecimal totalDiscountPrice = new BigDecimal(0);
        //获取应收金额
        BigDecimal receivables = new BigDecimal(0);
        //获取付款记录
        List<PaymentRepresentation> payments = new ArrayList<>();
        //获取付款使用的打折券
        List<String> discountCards = new ArrayList<>();

        result = new OrderRepresentation(command.getOrderId(),new Date(),member.getMemberId(),member.getMemberName(),member.getMemberLevel(),
                finalCardInfo.getCardType(),memberPointsIncreased,memberPoints,orderItems,totalPrice,discount,totalDiscountPrice,receivables,payments,discountCards);



        return result;
    }
}

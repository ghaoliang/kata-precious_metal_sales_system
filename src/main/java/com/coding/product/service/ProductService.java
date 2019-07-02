package com.coding.product.service;

import com.coding.product.Product;
import com.coding.utils.Constants;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private static Map<String, Product> productMap = new HashMap<String,Product>();

    /**
     * 初始化会员信息的memberMap
     */
    static{
        productMap.put("001001",new Product("世园会五十国钱币册","001001","册",new BigDecimal("998.00"),new String[]{},""));
        productMap.put("001002",new Product("2019北京世园会纪念银章大全40g","001002","盒",new BigDecimal("1380.00"),new String[]{}, Constants.DISCOUNT_9));
        productMap.put("003001",new Product("招财进宝","003001","条",new BigDecimal("1580.00"),new String[]{},Constants.DISCOUNT_95));
        productMap.put("003002",new Product("水晶之恋","003002","条",new BigDecimal("980.00"),new String[]{Constants.FULL_3_PURCHASE_HALF, Constants.FULL_3_DELIVER_1},""));
        productMap.put("002002",new Product("中国经典钱币套装","002002","套",new BigDecimal("998.00"),new String[]{Constants.FULL_1000_PURCHASE_10,Constants.FULL_2000_PURCHASE_30},""));
        productMap.put("002001",new Product("守扩之羽比翼双飞4.8g","002001","条",new BigDecimal("1080.00"),new String[]{Constants.FULL_3_PURCHASE_HALF, Constants.FULL_3_DELIVER_1},Constants.DISCOUNT_95));
        productMap.put("002003",new Product("中国银象棋12g","002003","套",new BigDecimal("698.00"),new String[]{Constants.FULL_1000_PURCHASE_10,Constants.FULL_2000_PURCHASE_30,Constants.FULL_3000_PURCHASE_350},Constants.DISCOUNT_9));
    }

    /**
     * 根据产品编号获取产品信息
     * @param productId
     * @return
     */
    public  Product getProductInfo(String productId){
        return productMap.get(productId);
    }
}

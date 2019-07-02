package com.coding.sales.member;

import com.coding.product.service.ProductService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void getProductInfo(){
        ProductService productService = new ProductService();

        assertEquals("中国经典钱币套装",productService.getProductInfo("002002").getProductName());
        assertEquals("水晶之恋",productService.getProductInfo("003002").getProductName());
        assertEquals("2019北京世园会纪念银章大全40g",productService.getProductInfo("001002").getProductName());
    }

}

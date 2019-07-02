package com.coding.product;

/**
 * 贵金属产品实体类
 * @author ghaoliang
 */
public class Product {

    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 单位
     */
    private String units;
    /**
     * 价格
     */
    private double price;
    /**
     * 满减活动
     */
    private String[] fullPurchase;
    /**
     * 参与打折
     */
    private String discount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getFullPurchase() {
        return fullPurchase;
    }

    public void setFullPurchase(String[] fullPurchase) {
        this.fullPurchase = fullPurchase;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}

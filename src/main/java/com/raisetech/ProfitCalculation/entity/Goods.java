package com.raisetech.ProfitCalculation.entity;

import lombok.*;

@AllArgsConstructor
@Getter
public class Goods {
    private int id;
    private String name;
    private int costPrice;
    private int shippingMethod;
    private int sellingPrice;
    private int profitRate;

    public void setName(String name) {
        this.name = name;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public void setShippingMethod(int shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setProfitRate(int profitRate) {
        this.profitRate = profitRate;
    }

    public Goods() {

    }

}

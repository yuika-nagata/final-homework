package com.raisetech.ProfitCalculation.entity;

import lombok.Data;

@Data
public class Goods {
    private final int id;
    private final String name;
    private final int costPrice;
    private final int shippingMethod;
    private final int sellingPrice;
    private final int profitRate;

}

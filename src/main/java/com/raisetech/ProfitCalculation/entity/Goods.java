package com.raisetech.ProfitCalculation.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Goods {
    private final int id;
    private final String name;
    private final int costPrice;
    private final int shippingMethod;
    private final int sellingPrice;
    private final int profitRate;

}

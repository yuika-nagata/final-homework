package com.raisetech.ProfitCalculation.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateForm {

    private final int id;

    @NotBlank
    @Length(max = 20)
    private final String name;

    @Positive
    private final int costPrice;

    @Positive
    private final int shippingMethod;

    @Min(300)
    private final int sellingPrice;
}

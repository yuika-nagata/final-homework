package com.raisetech.ProfitCalculation.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@RequiredArgsConstructor
@Getter
public class CreateForm {

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

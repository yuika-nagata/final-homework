package com.raisetech.ProfitCalculation.service;

import com.raisetech.ProfitCalculation.entity.CreateForm;
import com.raisetech.ProfitCalculation.entity.Goods;

import java.util.List;

public interface ProfitCalculationService {
    List<Goods> findAll();

    Goods findById(int id);

    void createGoods(Goods goods);
/*
    void updateUser(int id, CreateForm name);

    void deleteById(int id);
*/
}

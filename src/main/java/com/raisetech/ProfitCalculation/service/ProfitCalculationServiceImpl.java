package com.raisetech.ProfitCalculation.service;

import com.raisetech.ProfitCalculation.entity.CreateForm;
import com.raisetech.ProfitCalculation.entity.Goods;
import com.raisetech.ProfitCalculation.exception.ResourceNotFoundException;
import com.raisetech.ProfitCalculation.mapper.ProfitCalculationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfitCalculationServiceImpl implements ProfitCalculationService {

    private final ProfitCalculationMapper profitCalculationMapper;

    public ProfitCalculationServiceImpl(ProfitCalculationMapper profitCalculationMapper) {
        this.profitCalculationMapper = profitCalculationMapper;
    }

    @Override
    public List<Goods> findAll() {
        return profitCalculationMapper.findAll();
    }

    @Override
    public Goods findById(int id) {
        Optional<Goods> goods = profitCalculationMapper.findById(id);
        return profitCalculationMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }

    @Override
    public void createGoods(Goods goods) {
        profitCalculationMapper.createGoods(goods);

    }
/*
    @Override
    public void updateUser(int id, CreateForm name) {
        profitCalculationMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
        profitCalculationMapper.update(name);
    }

    @Override
    public void deleteById(int id) {
        profitCalculationMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
        profitCalculationMapper.deleteById(id);
    }*/
}

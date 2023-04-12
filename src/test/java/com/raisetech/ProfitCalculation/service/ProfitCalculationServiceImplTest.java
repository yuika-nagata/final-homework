package com.raisetech.ProfitCalculation.service;

import com.raisetech.ProfitCalculation.entity.CreateForm;
import com.raisetech.ProfitCalculation.entity.Goods;
import com.raisetech.ProfitCalculation.exception.ResourceNotFoundException;
import com.raisetech.ProfitCalculation.mapper.ProfitCalculationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfitCalculationServiceImplTest {

    @InjectMocks
    ProfitCalculationServiceImpl profitCalculationService;

    @Mock
    ProfitCalculationMapper profitCalculationMapper;

    @Test
    void 商品が全件取得できること() {
        List<Goods> products = List.of(new Goods(1, "iPad", 74800, 450, 90000, 5750), new Goods(2, "ポケモン", 6500, 450, 5000, -2450));
        doReturn(products).when(profitCalculationMapper).findAll();
        List<Goods> actual = profitCalculationService.findAll();
        assertThat(actual).isEqualTo(products);
    }

    @Test
    void 対象の商品が存在する場合対象の商品を1件取得する() {
        Goods products = new Goods(1, "iPad", 74800, 450, 90000, 5750);
        doReturn(Optional.of(products)).when(profitCalculationMapper).findById(1);
        Goods actual = profitCalculationService.findById(1);
        assertThat(actual).isEqualTo(products);
    }

    @Test
    public void 対象の商品が存在しない時例外が発生すること() {
        doReturn(Optional.empty()).when(profitCalculationMapper).findById(1);
        assertThatThrownBy(() -> profitCalculationService.findById(1))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("resource not found");
    }

    @Test
    public void 商品が登録ができること() {
        Goods goods = new Goods(1, "iPad", 74800, 450, 90000, 5750);
        doNothing().when(profitCalculationMapper).createGoods(goods);
        profitCalculationService.createGoods(goods);
        verify(profitCalculationMapper).createGoods(goods);
    }
}

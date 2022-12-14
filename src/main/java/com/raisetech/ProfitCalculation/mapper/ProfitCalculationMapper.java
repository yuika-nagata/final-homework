package com.raisetech.ProfitCalculation.mapper;

import com.raisetech.ProfitCalculation.entity.CreateForm;
import com.raisetech.ProfitCalculation.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProfitCalculationMapper {
    @Select("SELECT id,name,costPrice,shippingMethod,sellingPrice ,sellingPrice*0.9-(costPrice+shippingMethod) AS profitRate FROM goods")
    List<Goods> findAll();

    @Select("SELECT id,name,costPrice,shippingMethod,sellingPrice,sellingPrice*0.9-(costPrice+shippingMethod) AS profitRate FROM goods WHERE id = #{id}")
    Optional<Goods> findById(int id);

    @Insert("INSERT INTO goods(name,costPrice,shippingMethod,sellingPrice) VALUES (#{name},#{costPrice},#{shippingMethod},#{sellingPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createGoods(CreateForm form);
/*
    @Update("UPDATE names SET name = #{name} WHERE id = #{id}")
    void update(CreateForm name);

    @Delete("DELETE FROM names WHERE id = #{id}")
    void deleteById(int id);*/
}

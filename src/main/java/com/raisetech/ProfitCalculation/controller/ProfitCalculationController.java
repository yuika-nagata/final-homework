package com.raisetech.ProfitCalculation.controller;

import com.raisetech.ProfitCalculation.entity.CreateForm;
import com.raisetech.ProfitCalculation.entity.Goods;
import com.raisetech.ProfitCalculation.service.ProfitCalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class ProfitCalculationController {

    private final ProfitCalculationService profitCalculationService;

    public ProfitCalculationController(ProfitCalculationService profitCalculationService) {
        this.profitCalculationService = profitCalculationService;
    }

    @GetMapping("/products")
    public List<Goods> getNames() {
        return profitCalculationService.findAll();
    }

    @GetMapping("/products/{id}")
    public Goods getUser(@PathVariable("id") int id) throws Exception {
        return profitCalculationService.findById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Map<String, String>> createGoods(@RequestBody @Validated CreateForm form, UriComponentsBuilder uriBuilder) {
        profitCalculationService.createGoods(form);
        URI url = uriBuilder
                .path("products/" + form.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "登録が完了しました。"));
    }
/*
    @PatchMapping("names/{id}")
    public Map<String, String> updateUser(@PathVariable("id") int id, @RequestBody @Validated CreateForm name) {
        profitCalculationService.updateUser(id, name);
        return Map.of("message", "更新が完了しました。");
    }

    @DeleteMapping("names/{id}")
    public Map<String, String> deleteUser(@PathVariable int id) throws Exception {
        profitCalculationService.deleteById(id);
        return Map.of("message", "削除しました。");
    }
*/
}

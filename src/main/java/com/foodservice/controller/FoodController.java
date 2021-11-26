package com.foodservice.controller;

import com.foodservice.entity.Food;
import com.foodservice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping()
    Food save(@RequestBody Food food){
        return foodService.save(food);
    }

    @GetMapping("/{id}")
    ResponseEntity<Food> findById(@PathVariable("id") Long id){
        return foodService.findById(id);
    }

    @GetMapping()
    List<Food> findAll(){
        return foodService.findAll();
    }

}

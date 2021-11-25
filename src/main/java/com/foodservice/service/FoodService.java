package com.foodservice.service;

import com.foodservice.entity.Food;
import com.foodservice.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public Food findById(long id){
        return foodRepository.findById(id).get();
    }

    public List<Food> findAll(){
        return foodRepository.findAll();
    }

}

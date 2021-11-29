package com.foodservice.service;

import com.foodservice.entity.ExceptionHandling;
import com.foodservice.entity.Food;
import com.foodservice.repository.FoodRepository;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Retry(name = "basic")
//    @RateLimiter(name = "multiRate", fallbackMethod = "fallBackMethod")
    public ResponseEntity<Food> findById(long id){
        Food food = foodRepository.findById(id).get();
        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }

    public List<Food> findAll(){
        return foodRepository.findAll();
    }

    private ResponseEntity<ExceptionHandling> fallBackMethod(RuntimeException exception){
        ExceptionHandling handling = new ExceptionHandling("Server gặp sự cố, vui lòng refresh trang vài giây sau");
        return new ResponseEntity<ExceptionHandling>(handling, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

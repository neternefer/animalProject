package com.ironhack.adopterservice.controller;

import com.ironhack.adopterservice.dao.Adopter;
import com.ironhack.adopterservice.dto.AdopterDTO;
import com.ironhack.adopterservice.repository.AdopterRepository;
import com.ironhack.adopterservice.service.AdopterService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopter")
public class adopterController {

    @Autowired
    private AdopterService adopterService;

    @Autowired
    private AdopterRepository adopterRepository;

    Logger logger = LoggerFactory.getLogger("AdopterServiceApplication.class");

    @GetMapping
    public List<Adopter> getAllAdopters(){
        return adopterRepository.findAll();
    }

    @PostMapping
    @Retry(name = "animal-service", fallbackMethod = "postMethodFallback")
    public Adopter storeNewAdopter(@RequestBody AdopterDTO adopter) {
        return adopterService.storeNewAdopter(adopter);
    }

    public Adopter postMethodFallback(Exception e) {
        logger.info("Fallback method called.");
        Adopter adopter = new Adopter(Long.valueOf(00000), "This information cannot be stored at this moment.", Long.valueOf(00000));
        return adopter;
    }

}

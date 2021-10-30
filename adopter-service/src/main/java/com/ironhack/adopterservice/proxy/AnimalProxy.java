package com.ironhack.adopterservice.proxy;

import com.ironhack.adopterservice.dto.AnimalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("ANIMAL-SERVICE")
public interface AnimalProxy {

    @GetMapping("/animals/{id}")
    public AnimalDTO getById(@PathVariable("id") Long id);

    @PutMapping("/animals/{id}")
    public AnimalDTO updateAvailability(@PathVariable("id") Long id);

}

package com.ironhack.adopterservice.service;

import com.ironhack.adopterservice.dao.Adopter;
import com.ironhack.adopterservice.dto.AdopterDTO;
import com.ironhack.adopterservice.proxy.AnimalProxy;
import com.ironhack.adopterservice.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdopterService {

    @Autowired
    private AnimalProxy animalProxy;

    @Autowired
    AdopterRepository adopterRepository;

    public Adopter storeNewAdopter(AdopterDTO adopterDTO) {
        if(animalProxy.getById(adopterDTO.getPet()).isAvailable() == true) {
            Adopter adopter = new Adopter(adopterDTO.getName(), adopterDTO.getPet());
            adopterRepository.save(adopter);
            animalProxy.updateAvailability(adopterDTO.getPet());
            return adopter;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This animal is not available.");
        }
    }

}

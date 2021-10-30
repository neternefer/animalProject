package com.ironhack.animalservice;

import com.ironhack.animalservice.dao.Animal;
import com.ironhack.animalservice.dto.AnimalDTO;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AnimalService animalService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAnimals(@RequestParam Optional<Type> type,
                                   @RequestParam Optional<Integer> min, @RequestParam Optional<Integer> max) {

        if(type.isPresent() && min.isPresent() && max.isPresent()) {
            return animalService.getByAgeAndType(type.get(), min.get(), max.get());
        } else if(type.isPresent()) {
            return animalService.getByType(type.get());
        } else if (min.isPresent() && max.isPresent()) {
            return animalService.getByAge(min.get(), max.get());
        } else {
            return animalRepository.findAll();
        }

    }

    @GetMapping("/{id}")
    public AnimalDTO getById(@PathVariable Long id) {
        return animalService.getAnimal(id);
    }

    @PutMapping("/{id}")
    public AnimalDTO updateAvailability(@PathVariable("id") long id) {
        return animalService.update(id);
    }

}

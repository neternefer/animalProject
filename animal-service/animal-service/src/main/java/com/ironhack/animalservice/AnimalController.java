package com.ironhack.animalservice;

import com.ironhack.animalservice.dao.Animal;
import com.ironhack.animalservice.dto.AnimalDTO;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    AnimalService animalService;

    @GetMapping
    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public AnimalDTO getById(@PathVariable Long id) {
        return animalService.getAnimal(id);
    }

    @GetMapping("/type/{type}")
    public List<Animal> getAvailableByType(@PathVariable("type") Type type) {
        return animalService.getByType(type);
    }

    @GetMapping( "/age")
    public List<Animal> getAvailableByAge(@RequestParam int min, @RequestParam int max) {
        return animalService.getByAge(min, max);
    }

    @PutMapping("/{id}")
    public AnimalDTO updateAvailability(@PathVariable("id") long id) {
        return animalService.update(id);
    }

}

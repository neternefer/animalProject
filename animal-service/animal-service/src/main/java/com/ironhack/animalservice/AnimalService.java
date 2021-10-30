package com.ironhack.animalservice;

import com.ironhack.animalservice.dao.Animal;
import com.ironhack.animalservice.dto.AnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> getByAge(int min, int max) {
        List<Animal> result = new ArrayList<>();
        List<Animal> rangeAnimals = animalRepository.findByAgeBetween(min, max);
        for(Animal animal: rangeAnimals) {
            if(animal.isAvailable() == true) {
                result.add(animal);
            }
        }
        return result;
    }

    public List<Animal> getByType(Type type) {
        List<Animal> result = new ArrayList<>();
        List<Animal> typeAnimals = animalRepository.findByType(type);
        for(Animal animal: typeAnimals) {
            if(animal.isAvailable() == true) {
                result.add(animal);
            }
        }
        return result;
    }

    public List<Animal> getByAgeAndType(Type type, int min, int max) {
        List<Animal> result = new ArrayList<>();
        List<Animal> typeAnimals = animalRepository.findByTypeAndAgeBetween(type, min, max);
        for(Animal animal: typeAnimals) {
            if(animal.isAvailable() == true) {
                result.add(animal);
            }
        }
        return result;
    }

    public AnimalDTO update(long id) {
        Animal animal = animalRepository.findById(id).get();
        animal.setAvailable(false);
        animalRepository.save(animal);
        return convertAnimalToDto(animal);
    }

    public AnimalDTO convertAnimalToDto(Animal animal) {
        AnimalDTO newAnimalDto = new AnimalDTO(animal.getId(), animal.getName(), animal.getType().toString(),
                animal.getAge(), animal.isAvailable());
        return newAnimalDto;
    }

    public Animal convertDtoToAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal(animalDTO.getId(), animalDTO.getName(), Type.valueOf(animalDTO.getType()),
                animalDTO.getAge(), animalDTO.isAvailable());
        return animal;
    }

    public AnimalDTO getAnimal(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Animal with id " + id + " does not exist."));
        return convertAnimalToDto(animal);
    }
}

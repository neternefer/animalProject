package com.ironhack.animalservice;

import com.ironhack.animalservice.dao.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByAgeBetween(int min, int max);
    List<Animal> findByType(Type type);
    List<Animal> findByTypeAndAgeBetween(Type type, int min, int max);

}

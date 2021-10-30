package com.ironhack.adopterservice.repository;

import com.ironhack.adopterservice.dao.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {
}

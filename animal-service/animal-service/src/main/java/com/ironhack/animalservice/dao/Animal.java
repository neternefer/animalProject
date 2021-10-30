package com.ironhack.animalservice.dao;

import com.ironhack.animalservice.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int age;

    private boolean available;

    public Animal(String name, Type type, int age, boolean available) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.available = available;
    }
}

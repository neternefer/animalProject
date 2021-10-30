package com.ironhack.animalservice.dto;

import com.ironhack.animalservice.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {
    private long id;

    private String name;

    private String type;

    private int age;

    private boolean available;
}

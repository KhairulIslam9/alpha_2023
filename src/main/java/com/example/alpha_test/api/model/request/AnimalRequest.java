package com.example.alpha_test.api.model.request;

import com.example.alpha_test.model.Animal;
import com.example.alpha_test.model.AnimalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimalRequest {

    private String name;
    private AnimalType type;
    private Integer userId;

    public static Animal toAnimal(AnimalRequest request) {
        Animal newAnimal = new Animal();
        newAnimal.setName(request.getName());
        newAnimal.setType(request.getType());
        newAnimal.setUserId(request.getUserId());

        return newAnimal;
    }
}

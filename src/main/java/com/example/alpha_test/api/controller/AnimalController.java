package com.example.alpha_test.api.controller;

import com.example.alpha_test.api.model.request.AnimalRequest;
import com.example.alpha_test.api.service.AnimalService;
import com.example.alpha_test.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService userService) {
        this.animalService = userService;
    }

    @GetMapping()
    public List<Animal> getAll() {
        return animalService.findAll();
    }

    @GetMapping("{animalId}")
    public Animal getById(@PathVariable Integer animalId) {
        return animalService.getById(animalId);
    }

    @PostMapping("/create")
    public Animal create(@RequestBody AnimalRequest request) {
        return this.animalService.saveOrUpdate(AnimalRequest.toAnimal(request));
    }

    @PutMapping("{animalId}")
    public Animal update(@PathVariable Integer animalId, @RequestBody Animal animal) {
        Animal retval = null;

        if (animalId != null && animal != null) {
            Animal original = animalService.getById(animalId);
            original.apply(animal);

            retval = animalService.saveOrUpdate(original);
        }
        return retval;
    }

    @DeleteMapping("{animalId}")
    public boolean delete(@PathVariable Integer animalId) {
       return animalService.delete(animalId);
    }
}

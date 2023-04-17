package com.example.alpha_test.api.service;

import com.example.alpha_test.model.Animal;
import com.example.alpha_test.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    public List<Animal> findAll() {
        return this.animalRepository.findAll();
    }

    public Animal getById(Integer animalId) {
        return this.animalRepository.findById(animalId).orElseThrow(EntityNotFoundException::new);
    }
    public Animal saveOrUpdate(final Animal animal){
        return this.animalRepository.save(animal);
    }

    public boolean delete(Integer animalId) {
        try {
            this.animalRepository.deleteById(animalId);
        } catch (Exception ex) {
            return false;
        }
        return  true;
    }
}

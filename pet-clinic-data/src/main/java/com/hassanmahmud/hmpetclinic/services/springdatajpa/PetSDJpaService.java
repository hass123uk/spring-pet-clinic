package com.hassanmahmud.hmpetclinic.services.springdatajpa;

import com.hassanmahmud.hmpetclinic.model.Pet;
import com.hassanmahmud.hmpetclinic.repositories.PetRepository;
import com.hassanmahmud.hmpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        var pets = new HashSet<Pet>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long petId) {
        petRepository.deleteById(petId);
    }
}

package com.hassanmahmud.hmpetclinic.services.springdatajpa;

import com.hassanmahmud.hmpetclinic.model.PetType;
import com.hassanmahmud.hmpetclinic.repositories.PetTypeRepository;
import com.hassanmahmud.hmpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springjpadata")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        var petTypes = new HashSet<PetType>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long petTypeId) {
        return petTypeRepository.findById(petTypeId).orElse(null);
    }

    @Override
    public PetType save(PetType pet) {
        return petTypeRepository.save(pet);
    }

    @Override
    public void delete(PetType pet) {
        petTypeRepository.delete(pet);
    }

    @Override
    public void deleteById(Long petTypeId) {
        petTypeRepository.deleteById(petTypeId);
    }
}



package com.hassanmahmud.hmpetclinic.repositories;

import com.hassanmahmud.hmpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

package com.hassanmahmud.hmpetclinic.repositories;

import com.hassanmahmud.hmpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName(String lastName);
}

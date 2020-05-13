package com.hassanmahmud.hmpetclinic.repositories;

import com.hassanmahmud.hmpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Vet, Long> {
}

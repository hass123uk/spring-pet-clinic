package com.hassanmahmud.hmpetclinic.repositories;

import com.hassanmahmud.hmpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}

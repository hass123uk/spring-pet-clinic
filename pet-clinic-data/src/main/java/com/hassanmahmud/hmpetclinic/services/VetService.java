package com.hassanmahmud.hmpetclinic.services;

import com.hassanmahmud.hmpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);
}

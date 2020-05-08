package com.hassanmahmud.hmpetclinic.services;

import com.hassanmahmud.hmpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastName);

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}

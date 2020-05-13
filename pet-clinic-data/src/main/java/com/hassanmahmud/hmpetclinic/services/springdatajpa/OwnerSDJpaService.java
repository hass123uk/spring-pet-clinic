package com.hassanmahmud.hmpetclinic.services.springdatajpa;

import com.hassanmahmud.hmpetclinic.model.Owner;
import com.hassanmahmud.hmpetclinic.repositories.OwnerRepository;
import com.hassanmahmud.hmpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        var owners = new HashSet<Owner>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}

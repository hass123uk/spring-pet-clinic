package com.hassanmahmud.hmpetclinic.services.map;

import com.hassanmahmud.hmpetclinic.model.Vet;
import com.hassanmahmud.hmpetclinic.services.CrudService;

import java.util.Set;

public class VetMapService<T, ID> extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

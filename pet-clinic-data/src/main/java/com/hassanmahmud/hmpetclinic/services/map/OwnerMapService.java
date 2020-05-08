package com.hassanmahmud.hmpetclinic.services.map;

import com.hassanmahmud.hmpetclinic.model.Owner;
import com.hassanmahmud.hmpetclinic.services.CrudService;

import java.util.Set;

public class OwnerMapService<T, ID> extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}

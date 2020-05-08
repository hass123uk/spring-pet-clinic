package com.hassanmahmud.hmpetclinic.services;

import com.hassanmahmud.hmpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}

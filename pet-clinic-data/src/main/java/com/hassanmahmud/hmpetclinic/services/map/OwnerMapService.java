package com.hassanmahmud.hmpetclinic.services.map;

import com.hassanmahmud.hmpetclinic.model.Owner;
import com.hassanmahmud.hmpetclinic.services.OwnerService;
import com.hassanmahmud.hmpetclinic.services.PetService;
import com.hassanmahmud.hmpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if (object == null)
            return null;

        if (object.getPets() == null)
            return super.save(object);

        object.getPets().forEach(pet -> {
            if (pet.getPetType() == null)
                throw new RuntimeException("Pet Type is required");

            //Ensure the pet type saved on the owner has an id.
            if (pet.getPetType().getId() == null) {
                var savedPetType = petTypeService.save(pet.getPetType());
                pet.setPetType(savedPetType);
            }

            if (pet.getId() == null) {
                var savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });

        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

}

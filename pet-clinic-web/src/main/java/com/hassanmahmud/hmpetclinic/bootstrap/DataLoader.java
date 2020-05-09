package com.hassanmahmud.hmpetclinic.bootstrap;

import com.hassanmahmud.hmpetclinic.model.Owner;
import com.hassanmahmud.hmpetclinic.model.Pet;
import com.hassanmahmud.hmpetclinic.model.PetType;
import com.hassanmahmud.hmpetclinic.model.Vet;
import com.hassanmahmud.hmpetclinic.services.OwnerService;
import com.hassanmahmud.hmpetclinic.services.PetTypeService;
import com.hassanmahmud.hmpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Washington");
        owner1.setCity("Miami");
        owner1.setTelephone("12351351");

        Pet mikesPet = new Pet();

        mikesPet.setOwner(owner1);
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogType);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("456 Washington");
        owner2.setCity("Miami");
        owner2.setTelephone("456736737");

        Pet fionaCat = new Pet();
        fionaCat.setOwner(owner2);
        fionaCat.setName("Miss purr");
        fionaCat.setPetType(savedCatType);
        fionaCat.setBirthDate(LocalDate.now());
        owner1.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}

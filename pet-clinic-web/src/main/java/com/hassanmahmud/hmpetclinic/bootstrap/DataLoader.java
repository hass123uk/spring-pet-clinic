package com.hassanmahmud.hmpetclinic.bootstrap;

import com.hassanmahmud.hmpetclinic.model.*;
import com.hassanmahmud.hmpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      SpecialityService specialityService, VisitService visitService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        var dog = PetType.builder().name("Dog").build();
        PetType savedDogType = petTypeService.save(dog);

        var cat = PetType.builder().name("Cat").build();
        PetType savedCatType = petTypeService.save(cat);

        var owner1 = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .address("123 Washington")
                .city("Miami")
                .telephone("124125124")
                .build();

        var mikesPet = Pet.builder()
                .owner(owner1)
                .name("Rosco")
                .petType(savedDogType)
                .birthDate(LocalDate.now())
                .build();

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

        Visit catVisit = new Visit();
        catVisit.setPet(fionaCat);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        System.out.println("Loaded Owners....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}

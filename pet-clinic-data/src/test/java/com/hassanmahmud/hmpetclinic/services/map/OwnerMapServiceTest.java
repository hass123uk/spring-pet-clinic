package com.hassanmahmud.hmpetclinic.services.map;

import com.hassanmahmud.hmpetclinic.model.Owner;
import com.hassanmahmud.hmpetclinic.services.PetService;
import com.hassanmahmud.hmpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerMapServiceTest {

    static Long OWNER_1_ID = 1L;
    static String OWNER_1_FIRST_NAME = "John";
    static String OWNER_1_LAST_NAME = "Doe";
    @Mock
    PetTypeService petTypeService;
    @Mock
    PetService petService;
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(petTypeService, petService);
        ownerMapService.save(Owner.builder()
                .id(OWNER_1_ID)
                .firstName(OWNER_1_FIRST_NAME)
                .lastName(OWNER_1_LAST_NAME)
                .build()
        );
    }

    @Test
    void findAll() {
        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        var owner1 = ownerMapService.findById(OWNER_1_ID);
        assertNotNull(owner1);
        assertEquals(OWNER_1_ID, owner1.getId());
        assertEquals(OWNER_1_FIRST_NAME, owner1.getFirstName());
    }

    @Test
    void findById_ownerNotSaved_getNull() {
        var owner1 = ownerMapService.findById(2L);
        assertNull(owner1);
    }

    @Test
    void findByLastName_ownerSaved_getOwner() {
        var owner1 = ownerMapService.findByLastName(OWNER_1_LAST_NAME);
        assertNotNull(owner1);
        assertEquals(OWNER_1_ID, owner1.getId());
        assertEquals(OWNER_1_FIRST_NAME, owner1.getFirstName());
    }

    @Test
    void findByLastName_ownerNotSaved_getNull() {
        var owner1 = ownerMapService.findByLastName("SomeName");
        assertNull(owner1);
    }

    @Test
    void deleteById_ownerSave_emptyList() {
        //Guard
        var allBeforeDelete = ownerMapService.findAll();
        assertEquals(1, allBeforeDelete.size());

        //Act
        ownerMapService.deleteById(OWNER_1_ID);

        //Assert
        var allAfterDelete = ownerMapService.findAll();
        assertEquals(0, allAfterDelete.size());
    }

    @Test
    void deleteById_ownerNotSave_nonEmptyList() {
        //Guard
        var allBeforeDelete = ownerMapService.findAll();
        assertEquals(1, allBeforeDelete.size());

        //Act
        ownerMapService.deleteById(2L);

        //Assert
        var allAfterDelete = ownerMapService.findAll();
        assertEquals(1, allAfterDelete.size());
    }

    @Test
    void delete_passOwnerWithSameId_emptyList() {
        ownerMapService.delete(ownerMapService.findById(OWNER_1_ID));

        //Assert
        var allAfterDelete = ownerMapService.findAll();
        assertEquals(0, allAfterDelete.size());
    }

    @Test
    void save_noId_IdGenerated() {
        var owner2 = Owner.builder().build();

        //Guard
        assertNull(owner2.getId());

        //Act
        var savedOwner = ownerMapService.save(owner2);

        //Assert
        assertNotNull(savedOwner.getId());
    }

    @Test
    void save_withId_idUnchanged() {
        var id = 2L;
        var owner2 = Owner.builder().id(id).build();

        //Act
        var savedOwner = ownerMapService.save(owner2);

        //Assert
        assertEquals(id, savedOwner.getId());
    }

}
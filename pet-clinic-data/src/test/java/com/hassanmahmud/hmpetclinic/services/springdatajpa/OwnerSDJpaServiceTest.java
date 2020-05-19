package com.hassanmahmud.hmpetclinic.services.springdatajpa;

import com.hassanmahmud.hmpetclinic.model.Owner;
import com.hassanmahmud.hmpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Potter";
    public static final long OWNER_ID_1 = 1L;
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner dummyOwner;

    @BeforeEach
    void setUp() {
        dummyOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(dummyOwner);
        var actual = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, actual.getLastName());
    }

    @Test
    void findAll() {
        var owners = List.of(
                Owner.builder().build(),
                Owner.builder().build()
        );
        when(ownerRepository.findAll()).thenReturn(owners);
        var actual = service.findAll();
        assertNotNull(actual);
        assertEquals(owners.size(), actual.size());
    }

    @Test
    void findById_found() {
        var optionalOwner = Optional.of(dummyOwner);
        when(ownerRepository.findById(any())).thenReturn(optionalOwner);
        Owner actual = service.findById(OWNER_ID_1);
        assertNotNull(actual);
        assertEquals(OWNER_ID_1, actual.getId());
    }

    @Test
    void findById_notFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner actual = service.findById(OWNER_ID_1);
        assertNull(actual);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(dummyOwner);
        var actual = service.save(Owner.builder().build());
        assertEquals(OWNER_ID_1, actual.getId());
    }

    @Test
    void delete() {
        service.delete(dummyOwner);
        verify(ownerRepository, times(1)).delete(dummyOwner);
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID_1);
        verify(ownerRepository, times(1)).deleteById(OWNER_ID_1);
    }
}
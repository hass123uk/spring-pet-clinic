package com.hassanmahmud.hmpetclinic.services.springdatajpa;

import com.hassanmahmud.hmpetclinic.model.Speciality;
import com.hassanmahmud.hmpetclinic.repositories.SpecialityRepository;
import com.hassanmahmud.hmpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        var specialities = new HashSet<Speciality>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long specialityId) {
        return specialityRepository.findById(specialityId).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long specialityId) {
        specialityRepository.deleteById(specialityId);
    }
}

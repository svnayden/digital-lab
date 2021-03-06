package com.naiden.digitallab.service;

import com.naiden.digitallab.model.Compound;
import com.naiden.digitallab.repository.CompoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompoundService {

    private final CompoundRepository compoundRepository;

    @Autowired
    public CompoundService(CompoundRepository compoundRepository) {
        this.compoundRepository = compoundRepository;
    }

    public Iterable<Compound> findAll() {
        return compoundRepository.findAll();
    }

    public Compound findById(Long id) {
        return compoundRepository.findById(id).orElse(new Compound());
    }

    public Compound save(Compound compound) {
        String iupacName = compound.getIupacName();
        if (compound.getShortName().isEmpty() && !iupacName.isEmpty()) compound.setShortName(iupacName);
        return compoundRepository.save(compound);
    }

    public void deleteById(Long aLong) {
        compoundRepository.deleteById(aLong);
    }

    public void update(Compound compound) {
        compoundRepository.save(compound);
    }

}

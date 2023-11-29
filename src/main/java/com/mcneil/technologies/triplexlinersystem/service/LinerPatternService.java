package com.mcneil.technologies.triplexlinersystem.service;

import com.mcneil.technologies.triplexlinersystem.model.LinerPattern;
import com.mcneil.technologies.triplexlinersystem.repository.LinerPatternMeasurementInfoRepository;
import com.mcneil.technologies.triplexlinersystem.repository.LinerPatternRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LinerPatternService {
    @Autowired
    private LinerPatternRepository linerPatternRepository;

    public void saveLinerPattern(LinerPattern linerPattern) {
        linerPatternRepository.save(linerPattern);
    }

    public LinerPattern getLinerPatternById(int id) {
        return linerPatternRepository.findById(id).get();
    }

    public void deleteLinerPatternById(int id) {
        linerPatternRepository.deleteById(id);
    }

    public void deleteAllLinerPattern() {
        linerPatternRepository.deleteAll();
    }

    public Iterable<LinerPattern> getAllLinerPattern() {
        return linerPatternRepository.findAll();
    }

    public boolean linerPatternExistsById(int id) {
        return linerPatternRepository.existsById(id);
    }

    public long countLinerPattern() {
        return linerPatternRepository.count();
    }

    public void updateLinerPattern(LinerPattern linerPattern) {
        linerPatternRepository.save(linerPattern);
    }

    public void deleteLinerPattern(LinerPattern linerPattern) {
        linerPatternRepository.delete(linerPattern);
    }

    public Iterable<LinerPattern> saveAllLinerPattern(Iterable<LinerPattern> linerPatternIterable) {
        return linerPatternRepository.saveAll(linerPatternIterable);
    }
}

package com.mcneil.technologies.triplexlinersystem.service;

import com.mcneil.technologies.triplexlinersystem.model.LinerPatternMeasurementInfo;
import com.mcneil.technologies.triplexlinersystem.repository.LinerPatternMeasurementInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinerPatternMeasurementInfoService {
    @Autowired
    private LinerPatternMeasurementInfoRepository linerPatternMeasurementInfoRepository;

    public void saveLinerPatternMeasurementInfo(LinerPatternMeasurementInfo linerPatternMeasurementInfo) {
        linerPatternMeasurementInfoRepository.save(linerPatternMeasurementInfo);
    }

    public LinerPatternMeasurementInfo getLinerPatternMeasurementInfoById(int id) {
        return linerPatternMeasurementInfoRepository.findById(id).get();
    }

    public void deleteLinerPatternMeasurementInfoById(int id) {
        linerPatternMeasurementInfoRepository.deleteById(id);
    }

    public void deleteAllLinerPatternMeasurementInfo() {
        linerPatternMeasurementInfoRepository.deleteAll();
    }

    public Iterable<LinerPatternMeasurementInfo> getAllLinerPatternMeasurementInfo() {
        return linerPatternMeasurementInfoRepository.findAll();
    }

    public boolean linerPatternMeasurementInfoExistsById(int id) {
        return linerPatternMeasurementInfoRepository.existsById(id);
    }

    public long countLinerPatternMeasurementInfo() {
        return linerPatternMeasurementInfoRepository.count();
    }

    public void updateLinerPatternMeasurementInfo(LinerPatternMeasurementInfo linerPatternMeasurementInfo) {
        linerPatternMeasurementInfoRepository.save(linerPatternMeasurementInfo);
    }

    public void deleteLinerPatternMeasurementInfo(LinerPatternMeasurementInfo linerPatternMeasurementInfo) {
        linerPatternMeasurementInfoRepository.delete(linerPatternMeasurementInfo);
    }

    public Iterable<LinerPatternMeasurementInfo> saveAllLinerPatternMeasurementInfo(Iterable<LinerPatternMeasurementInfo> linerPatternMeasurementInfoIterable) {
        return linerPatternMeasurementInfoRepository.saveAll(linerPatternMeasurementInfoIterable);
    }
}

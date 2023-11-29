package com.mcneil.technologies.triplexlinersystem.service;

import com.mcneil.technologies.triplexlinersystem.model.LinerPatternImageData;
import com.mcneil.technologies.triplexlinersystem.repository.LinerPatternImageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class LinerPatternImageDataService {

    @Autowired
    private LinerPatternImageDataRepository linerPatternImageDataRepository;


    public void saveLinerPatternImageData(MultipartFile[] imageFile) {

    }

    public void saveLinerPatternImageData(LinerPatternImageData linerPatternImageData) {
        linerPatternImageDataRepository.save(linerPatternImageData);
    }

    public LinerPatternImageData getLinerPatternImageDataById(int id) {
        return linerPatternImageDataRepository.findById(id).get();
    }
}

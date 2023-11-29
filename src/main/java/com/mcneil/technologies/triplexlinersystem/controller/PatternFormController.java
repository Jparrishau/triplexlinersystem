package com.mcneil.technologies.triplexlinersystem.controller;

import com.mcneil.technologies.triplexlinersystem.Utils;
import com.mcneil.technologies.triplexlinersystem.model.LinerPattern;
import com.mcneil.technologies.triplexlinersystem.model.wrapper.LinerPatternImage;
import com.mcneil.technologies.triplexlinersystem.model.LinerPatternImageData;
import com.mcneil.technologies.triplexlinersystem.model.wrapper.LinerPatternImageWrapper;
import com.mcneil.technologies.triplexlinersystem.repository.LinerPatternRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PatternFormController {
    private final LinerPatternRepository linerPatternRepository;
    private final String filePath = "C:\\Users\\Taylor\\Documents\\McNeil_Technologies\\Images\\lpImages\\";

    public PatternFormController(LinerPatternRepository linerPatternRepository) {
        this.linerPatternRepository = linerPatternRepository;
    }

    @GetMapping("/patternform")
    public String patternForm(ModelMap model, @RequestParam(name = "type") String paramType) {
        String formattedType = Utils.formatString(paramType);
        model.addAttribute("type", formattedType);
        model.addAttribute("linerPattern", new LinerPattern());
        model.addAttribute("linerPatternImageWrapper", new LinerPatternImageWrapper());
        return "patternform";
    }

    @PostMapping(value = "/patternform")
    public String submitPatternForm(@ModelAttribute("linerPattern") LinerPattern linerPattern,
                                    @ModelAttribute("linerPatternImageWrapper") LinerPatternImageWrapper linerPatternImageWrapper,
                                    BindingResult bindingResult,
                                    HttpSession session) {
        if (bindingResult.hasErrors()) {
            //errors processing
        }

        try {
            List<LinerPatternImageData> beforeImages = uploadLinerPatternImage(linerPatternImageWrapper.getBeforeImage());
            List<LinerPatternImageData> locationImages = uploadLinerPatternImage(linerPatternImageWrapper.getLocationImage());
            linerPattern.setLinerPatternBeforeImageData(beforeImages);
            linerPattern.setLinerPatternLocationImageData(locationImages);
        } catch (IOException e) {
            session.setAttribute("error", e.getCause());
            session.setAttribute("success", false);
            return "redirect:/?success=false";
        }

        linerPatternRepository.save(linerPattern);
        session.setAttribute("success", true);
        return "redirect:/?success=true";
    }

    public List<LinerPatternImageData> uploadLinerPatternImage(LinerPatternImage linerPatternImage) throws IOException {
        List<LinerPatternImageData> linerPatternImageDataList = new ArrayList<>();
        MultipartFile[] imageFiles = linerPatternImage.getImageFiles();
        String imageType = linerPatternImage.getImageType();

        int index = 0;
        for (MultipartFile file : linerPatternImage.getImageFiles()) {
                byte[] bytes = file.getBytes();
                Date dateCreated = new Date();
                String fileName = imageType + "Photo" + "_" + index + "_" + dateCreated.getTime() + ".jpg";
                String filePath = this.filePath + fileName;
                //Write the file to the file system
                Path path = Paths.get(filePath);
                Files.write(path, bytes);
                //Create the LinerPatternImageData object
                LinerPatternImageData linerPatternImageData = createLinerPatternImageData(imageType, fileName, filePath, dateCreated);
                linerPatternImageDataList.add(linerPatternImageData);
                index++;
        }
        return linerPatternImageDataList;
    }

    public LinerPatternImageData createLinerPatternImageData(String imageType, String imageName, String imagePath, Date dateCreated) {
        LinerPatternImageData linerPatternImageData = new LinerPatternImageData();
        linerPatternImageData.setImageType(imageType);
        linerPatternImageData.setImageName(imageName);
        linerPatternImageData.setImagePath(imagePath);
        linerPatternImageData.setDateCreated(dateCreated);
        return linerPatternImageData;
    }
}
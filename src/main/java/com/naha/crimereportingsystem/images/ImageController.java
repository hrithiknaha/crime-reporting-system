package com.naha.crimereportingsystem.images;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/src" + "/main" + "/resources" + "/static"
            + "/images";

    @GetMapping("/upload")
    public String uploadImageRoute() {
        return "image/upload";
    }

    @PostMapping("/upload")
    public String uploadImagePostRoute(Model model, @RequestParam("file") MultipartFile file) {
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getOriginalFilename());
        model.addAttribute("filePath", file.getOriginalFilename());
        return "image/view";
    }
}
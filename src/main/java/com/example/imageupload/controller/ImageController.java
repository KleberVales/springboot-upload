package com.example.imageupload.controller;

import com.example.imageupload.entity.ImageEntity;
import com.example.imageupload.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ImageEntity> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(imageService.save(file));
    }
}

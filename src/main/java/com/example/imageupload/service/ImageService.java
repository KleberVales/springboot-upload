package com.example.imageupload.service;

import com.example.imageupload.entity.ImageEntity;
import com.example.imageupload.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    private final ImageRepository repository;

    public ImageService(ImageRepository repository) {
        this.repository = repository;
    }

    public ImageEntity save(MultipartFile file) throws IOException {
        ImageEntity entity = new ImageEntity();
        entity.setName(file.getOriginalFilename());

        byte[] bytes = file.getBytes();
        System.out.println("Bytes length: " + bytes.length);  // Imprime tamanho dos bytes recebidos

        entity.setData(bytes);
        return repository.save(entity);
    }

}

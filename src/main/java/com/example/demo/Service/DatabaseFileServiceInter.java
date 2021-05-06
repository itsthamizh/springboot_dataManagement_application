package com.example.demo.Service;

import com.example.demo.Model.DatabaseFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DatabaseFileServiceInter {

    List<DatabaseFile> findAll();

    DatabaseFile getFile(Integer fileId);

    DatabaseFile storeFile(MultipartFile file);

}

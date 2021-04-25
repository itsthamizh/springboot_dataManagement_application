package com.example.demo.Service;

import java.io.IOException;
import java.util.List;


import com.example.demo.Exception.FileNotFoundException;
import com.example.demo.Exception.FileStorageException;
import com.example.demo.Model.DatabaseFile;
import com.example.demo.Repository.DatabaseFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class DatabaseFileService implements DatabaseFileServiceInter {

    @Autowired
    private DatabaseFileRepository dbFileRepository;



    public DatabaseFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DatabaseFile getFile(Integer fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }




    @Override
    public List<DatabaseFile> findAll() {
        return dbFileRepository.findAll();
    }


}

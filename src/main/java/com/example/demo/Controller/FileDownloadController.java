package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Model.DatabaseFile;
import com.example.demo.Service.DatabaseFileService;
import com.example.demo.Service.DatabaseFileServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController

public class FileDownloadController {

    @Autowired
    private DatabaseFileServiceInter databaseFileServiceInter;


    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id, HttpServletRequest request) {
        // Load file as Resource
        DatabaseFile databaseFile = databaseFileServiceInter.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
                .body(new ByteArrayResource(databaseFile.getData()));
    }


}

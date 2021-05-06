package com.example.demo;

import com.example.demo.Controller.FogController;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan({"package com.example.demo","Controller"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

package com.naha.crimereportingsystem;

import java.io.File;

import com.naha.crimereportingsystem.images.ImageController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CRSApplication {

	public static void main(String[] args) {
		new File(ImageController.uploadDirectory).mkdir();
		SpringApplication.run(CRSApplication.class, args);
	}

}

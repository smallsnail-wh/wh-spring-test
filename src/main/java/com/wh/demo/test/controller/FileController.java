package com.wh.demo.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wh.demo.test.model.FileInfo;

@RestController
@RequestMapping("/file")
public class FileController {

	@PostMapping
	public FileInfo upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		String folder = "/wh-test/src/main/java/com/wh/demo/test/controller";
		
		File localFile = new File(folder, new Date().getTime()+".txt") ;
		file.transferTo(localFile);
		return new FileInfo(localFile.getAbsolutePath());
	}
	
}

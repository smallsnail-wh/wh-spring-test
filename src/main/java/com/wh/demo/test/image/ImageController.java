package com.wh.demo.test.image;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	ImageConfig imageConfig;

	@PutMapping("/img/upload")
	public String uploadImg(@RequestParam("editormd-image-file") MultipartFile multipartFile) {
		if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
			throw new RuntimeException("IMG_NOT_EMPTY");
		}
		String contentType = multipartFile.getContentType();
		if (!contentType.contains("")) {
			throw new RuntimeException("IMG_FORMAT_ERROR");
		}
		String root_fileName = multipartFile.getOriginalFilename();
		logger.info("上传图片:name={},type={}", root_fileName, contentType);
		// 处理图片
		/* User currentUser = userService.getCurrentUser(); */
		// 获取路径
		/* String return_path = ImageUtil.getFilePath(currentUser); */
		String filePath = imageConfig.getLocation();
		logger.info("图片保存路径={}", filePath);
		String file_name = null;
		try {
			file_name = ImageUtil.saveImg(multipartFile, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath + file_name;
	}

	@GetMapping("/img/download")
	public String downloadImg(@RequestParam("url") String url) {

		String filePath = imageConfig.getLocation();
		String file_name = null;

		try {
			file_name = ImageUtil.saveImg(url, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath+"/" + file_name;
	}

}

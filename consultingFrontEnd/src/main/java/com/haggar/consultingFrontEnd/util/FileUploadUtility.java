package com.haggar.consultingFrontEnd.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	//public static final String ABS_PATH = "\\Users\\mac\\Rapport\\Consulting\\Consulting\\consultingFrontEnd\\src\\main\\webapp\\assets\\images\\";
	public static final String ABS_PATH = "/Users/mac/Rapport/Consulting/Consulting/consultingFrontEnd/src/main/webapp/assets";
	public static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		
		// get real path
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		// making sure all the directory exist
		// create directory
		
		if(!new File(ABS_PATH).exists()) {
			// create the directory
			
			new File(ABS_PATH).mkdirs();
			
			
		}
		
		if(!new File(REAL_PATH).exists()) {
			// create the directory
			
			new File(REAL_PATH).mkdirs();
			
			
		}
		
		try {
			// sever upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));  // file -> Product
			
			//project directory upload
			
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			
		} catch (Exception ex) {
			
			
			
		}
		
	}

}

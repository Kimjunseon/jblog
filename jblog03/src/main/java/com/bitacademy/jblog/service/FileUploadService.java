package com.bitacademy.jblog.service;

import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.exception.FileUploadServiceException;

@Service
public class FileUploadService {
	private static String RESTORE_PATH = "/mysite-uploads";
	private static String URL_BASE = "/images";
	
	
	public String restore(MultipartFile multipartFile) throws FileUploadServiceException {
		String url = null;
		
		try {
			if(multipartFile.isEmpty()) {
				return url;
			}
			
			File restoreDirectory = new File(RESTORE_PATH);
			if(!restoreDirectory.exists()) {
				restoreDirectory.mkdirs();
			}
			
			String originalFilename = multipartFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
			String restoreFilename = generateSaveFilename(extName);
			// Long fileSize = multipartFile.getSize();
			
			byte[] data = multipartFile.getBytes();
			
			OutputStream os = new FileOutputStream(RESTORE_PATH + "/" + restoreFilename);
			os.write(data);
			os.close();
			
			url = URL_BASE + "/" + restoreFilename;
		} catch (IOException e) {
			throw new FileUploadServiceException(e.toString());
		}
		
		return url;
		
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}

}
package com.Project.FormMaster.ImageUpload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtil {
	
	 public static void saveFile(String uploadDir, String fileName, MultipartFile
			  multipartFile) throws IOException { java.nio.file.Path uploadPath = Paths.get(uploadDir);
			  if (!Files.exists(uploadPath)) { Files.createDirectories(uploadPath); }
			  
			  try (InputStream inputStream = multipartFile.getInputStream()) { java.nio.file.Path
			  filePath = uploadPath.resolve(fileName); Files.copy(inputStream, filePath,
			  StandardCopyOption.REPLACE_EXISTING); } catch (IOException ioe) { throw new
			  IOException("Could not save image file: " + fileName, ioe); } }

}

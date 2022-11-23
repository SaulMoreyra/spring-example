package mx.org.example.pojos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import mx.org.example.entity.Pdf;

public class FileStorage {
	private MultipartFile file;
	private String fileDirection;
	private String baseContext;
	private String identify;
	
	public FileStorage (MultipartFile file, String baseContext) {
		this.file = file;
		this.baseContext = baseContext;
	}
	
	public FileStorage() {}
	
	public static FileStorage construct() {
		return new FileStorage();
	}
	
	public static FileStorage construct(MultipartFile file, String baseContext) {
		return new FileStorage(file, baseContext);
	}
		
	public FileStorage makeDestiny () {
		UUID uuid = UUID.randomUUID();
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		String fileIdentity = uuid.toString();
		identify = fileIdentity + "." + fileExtension;
		fileDirection = Paths.get(baseContext, Pdf.RESOURCES_FOLDER, Pdf.FILES_FOLDER, identify).toString();
		return this;
	}
	
	public FileStorage storage() {
		if(file != null) {
			try { 		
				File newFile = new File(fileDirection);
				file.transferTo(newFile); 
			} catch (IOException e) {
                e.printStackTrace();
            }
		}
		return this;
	}
	
	
	
	public MultipartFile getFile() {
		return file;
	}

	public FileStorage setFile(MultipartFile file) {
		this.file = file;
		return this;
	}

	public String getBaseContext() {
		return baseContext;
	}

	public FileStorage setBaseContext(String baseContext) {
		this.baseContext = baseContext;
		return this;
	}

	public static String getFilePath(String baseContext) {
		return Paths.get(baseContext, Pdf.RESOURCES_FOLDER, Pdf.FILES_FOLDER).toString();
	}
	
	public static String getFilePath(String baseContext, String identify) {
		return Paths.get(baseContext, Pdf.RESOURCES_FOLDER, Pdf.FILES_FOLDER, identify).toString();
	}
	
	public static String getFileUrl(String identify) {
		return Paths.get(Pdf.RESOURCES_FOLDER, Pdf.FILES_FOLDER, identify).toString();
	}
	
	public String getIdentify() {
		return identify;
	}

	public static boolean delete(String identify, String baseContext) {
		String filedirection = getFilePath(baseContext, identify);
		Path path = Paths.get(filedirection);
		try {
			Files.delete(path);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}

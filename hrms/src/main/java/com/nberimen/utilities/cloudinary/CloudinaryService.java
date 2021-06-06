package com.nberimen.utilities.cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

	public Map<?,?> upload(MultipartFile multipartFile) throws IOException ;
	public Map<?,?> delete(String id) throws IOException;
	public File convert(MultipartFile multipartFile)  throws IOException;
}

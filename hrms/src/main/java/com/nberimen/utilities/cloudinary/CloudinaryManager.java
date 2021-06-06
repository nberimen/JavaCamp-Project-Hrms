package com.nberimen.utilities.cloudinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements CloudinaryService {

	Cloudinary cloudinary;
	private Map<String, String> valuesMap = new HashMap<>();

	CloudinaryManager() {
		valuesMap.put("cloud_name", "nberimen");
		valuesMap.put("api_key", "642897657698571");
		valuesMap.put("api_secret", "dAjHz-1zu1k6DsUTukwzBXG94XA");
		cloudinary = new Cloudinary(valuesMap);

	}

	@Override
	public Map<?,?> upload(MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		Map<?,?> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;

	}

	@Override
	public Map<?,?> delete(String id) throws IOException {
		Map<?,?> result= cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
		

	}

	@Override
	public File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return file;
	}

}

package kodlamaio.hrms.adapters.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.results.DataResult;

public interface ImageUploadService {
	
	@SuppressWarnings("rawtypes")
	DataResult<Map> imageUploadFileToSystem(MultipartFile imageFile);

}

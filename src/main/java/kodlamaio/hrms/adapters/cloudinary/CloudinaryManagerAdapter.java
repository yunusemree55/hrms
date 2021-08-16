package kodlamaio.hrms.adapters.cloudinary;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.results.DataResult;

@Service
public class CloudinaryManagerAdapter implements ImageUploadService {

	@Override
	@SuppressWarnings("rawtypes")
	public DataResult<Map> imageUploadFileToSystem(MultipartFile imageFile) {
		
		CloudinaryManager cloudinaryManager = new CloudinaryManager();
		
		 DataResult<Map> uploadMap = cloudinaryManager.imageUploadFile(imageFile);
		 
		 
		 return uploadMap;
		
	}

}

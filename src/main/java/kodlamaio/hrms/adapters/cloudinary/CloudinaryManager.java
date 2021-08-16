package kodlamaio.hrms.adapters.cloudinary;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.SuccessDataResult;

@Service
public class CloudinaryManager {
	
	private Cloudinary cloudinary;

	public CloudinaryManager() {
	
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "djmijmjdq",
				  "api_key", "338941876611229",
				  "api_secret", "kp9LmwLSUBrQzvV0JiL_te2pzIc"));
	}
	
	@SuppressWarnings("rawtypes")
	public DataResult<Map> imageUploadFile(MultipartFile imageFile){
		
		try {
			
			@SuppressWarnings("unchecked")
			Map<String, String> uploadResult = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			
			return new SuccessDataResult<>(uploadResult);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return new ErrorDataResult<>();
	}

}

package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Image;

public interface ImageService {
	
	DataResult<List<Image>> getAll();
	DataResult<Image> findByJobSeekerId(int jobSeekerId);
	Result add(Image image,MultipartFile imageFile);

}

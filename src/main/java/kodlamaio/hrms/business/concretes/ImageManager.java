package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.adapters.cloudinary.ImageUploadService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Cv.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private ImageUploadService imageUploadService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<Image> findByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<Image>(this.imageDao.findByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result add(Image image, MultipartFile imageFile) {
		
		@SuppressWarnings("unchecked")
		
		Map<String, String> imageUpload = this.imageUploadService.imageUploadFileToSystem(imageFile).getData();
		
		image.setUrl(imageUpload.get("url"));
		this.imageDao.save(image);
		
		return new SuccessResult("Fotoğraf kaydedildi");
	}

}

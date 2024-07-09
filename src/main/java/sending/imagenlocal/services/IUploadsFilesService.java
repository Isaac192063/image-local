package sending.imagenlocal.services;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadsFilesService {
    String handleFileUpload(MultipartFile multipartFile) throws Exception;
}

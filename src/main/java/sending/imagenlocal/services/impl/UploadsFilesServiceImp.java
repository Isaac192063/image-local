package sending.imagenlocal.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sending.imagenlocal.services.IUploadsFilesService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadsFilesServiceImp implements IUploadsFilesService {

    @Override
    public String handleFileUpload(MultipartFile multipartFile) throws Exception {
        try {
             String filename = UUID.randomUUID().toString();

             byte[] bytes = multipartFile.getBytes();

             String fileOriginalName = multipartFile.getOriginalFilename();

             long fileSize = multipartFile.getSize();

             long maxFileSizes = 5 * 1024 * 1024;

             if(fileSize > maxFileSizes){
                 return "sobrepaso la cantidad de 5MB permitidas ";
             }

             if(!fileOriginalName.endsWith(".jpg")
             && !fileOriginalName.endsWith(".png")
             && !fileOriginalName.endsWith(".jpeg")){
                 return "solo imagenes validas";
             }

             String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));

             String newFileName = filename + fileExtension;

            File folder = new File("src/main/uploads");

            if(!folder.exists()){
                folder.mkdir();
            }

            Path path = Paths.get("src/main/uploads/"+newFileName);

            Files.write(path, bytes);

            return "imagen subida";

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

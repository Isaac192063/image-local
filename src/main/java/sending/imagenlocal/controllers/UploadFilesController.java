package sending.imagenlocal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sending.imagenlocal.services.IUploadsFilesService;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {

    @Autowired
    private IUploadsFilesService iUploadsFilesService;

    @PostMapping("picture")
    private ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        return  new ResponseEntity<>(iUploadsFilesService.handleFileUpload(file), HttpStatus.OK);
    }
}

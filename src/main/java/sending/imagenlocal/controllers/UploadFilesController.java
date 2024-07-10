package sending.imagenlocal.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sending.imagenlocal.dto.RequestDTO;
import sending.imagenlocal.exceptions.ResourceInvalidException;
import sending.imagenlocal.models.Users;
import sending.imagenlocal.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {

    @Autowired
    private IUserService userService;

    @PostMapping("picture")
    private ResponseEntity<Users> uploadImage(@RequestPart("file") MultipartFile file, @RequestPart("user") String user)  {

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(user);
        RequestDTO dto;
        try{
            dto = objectMapper.readValue(user, RequestDTO.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new ResourceInvalidException("Datos ingresados del usuario no validos");
        }

        System.out.println(file);
        System.out.println(dto);
        return  new ResponseEntity<>(userService.saveUser(dto, file), HttpStatus.OK);
    }

    @GetMapping("user-all")
    public ResponseEntity<List<Users>> findAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Users> findByUserId(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }


}

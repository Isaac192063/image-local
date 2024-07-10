package sending.imagenlocal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sending.imagenlocal.dto.RequestDTO;
import sending.imagenlocal.exceptions.LimitExceededException;
import sending.imagenlocal.exceptions.NotFoundException;
import sending.imagenlocal.models.Users;
import sending.imagenlocal.respository.UserRepository;
import sending.imagenlocal.services.IUploadsFilesService;
import sending.imagenlocal.services.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUploadsFilesService iUploadsFilesService;

    @Override
    public Users saveUser(RequestDTO users, MultipartFile file) {

        String path = "";

        try{
        path = iUploadsFilesService.handleFileUpload(file);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return userRepository.save(Users.builder()
                        .name(users.getName())
                        .image(path)
                .build());
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {

        Optional<Users> userCandidate = userRepository.findById(id);

        if(userCandidate.isEmpty()){
            throw new NotFoundException("El usuario no se encontro");
        }

        return userCandidate.get();
    }
}

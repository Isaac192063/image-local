package sending.imagenlocal.services;

import org.springframework.web.multipart.MultipartFile;
import sending.imagenlocal.dto.RequestDTO;
import sending.imagenlocal.models.Users;

import java.util.List;

public interface IUserService {
    Users saveUser(RequestDTO users, MultipartFile file);
    List<Users> getAllUsers();
    Users getUserById(Long id);
}

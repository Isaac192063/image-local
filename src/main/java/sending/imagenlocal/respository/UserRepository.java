package sending.imagenlocal.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sending.imagenlocal.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}

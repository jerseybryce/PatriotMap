package mason.patriotmaps.repository;

import mason.patriotmaps.entity.UserEntity;
import mason.patriotmaps.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*Repository class for the database*/
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}

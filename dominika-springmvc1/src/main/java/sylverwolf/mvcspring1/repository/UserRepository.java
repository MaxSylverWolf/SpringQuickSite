package sylverwolf.mvcspring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import sylverwolf.mvcspring1.entity.User;

import java.util.List;

/**
 * Created by szkolenia on 2017-07-10.
 */

public interface UserRepository extends JpaRepository<User, Integer>{


}

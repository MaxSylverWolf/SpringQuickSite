package sylverwolf.mvcspring1.repository;

import org.springframework.data.repository.CrudRepository;
import sylverwolf.mvcspring1.entity.EmailAddress;

/**
 * Created by szkolenia on 2017-07-14.
 */
public interface EmailAddressRepository extends CrudRepository<EmailAddress, Integer> {
}

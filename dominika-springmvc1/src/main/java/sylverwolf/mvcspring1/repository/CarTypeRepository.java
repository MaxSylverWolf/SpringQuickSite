package sylverwolf.mvcspring1.repository;

import org.springframework.data.repository.CrudRepository;
import sylverwolf.mvcspring1.entity.CarType;

/**
 * Created by szkolenia on 2017-07-14.
 */
public interface CarTypeRepository extends CrudRepository<CarType, Integer> {
}

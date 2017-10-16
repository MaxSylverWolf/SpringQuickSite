package sylverwolf.mvcspring1.repository;

import org.springframework.data.repository.CrudRepository;
import sylverwolf.mvcspring1.entity.Car;

/**
 * Created by szkolenia on 2017-07-14.
 */
public interface CarRepository extends CrudRepository<Car, Integer> {
}

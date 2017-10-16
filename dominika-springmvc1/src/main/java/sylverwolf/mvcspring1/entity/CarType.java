package sylverwolf.mvcspring1.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by szkolenia on 2017-07-14.
 */
@Entity
@Data
@Table(name = "samochod_marka")
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     private String marka;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "carType")
     private Car car;

}

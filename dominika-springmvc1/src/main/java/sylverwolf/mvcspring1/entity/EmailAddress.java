package sylverwolf.mvcspring1.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by szkolenia on 2017-07-14.
 */
@Entity
@Data
@Table(name = "email")
public class EmailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    private String adres;


}

package sylverwolf.mvcspring1.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by szkolenia on 2017-07-14.
 */
@Entity
@Data
@Table(name = "adres")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_user")
    private User user;

    private String ulica;

    private String nr_domu;

    private String miasto;
}

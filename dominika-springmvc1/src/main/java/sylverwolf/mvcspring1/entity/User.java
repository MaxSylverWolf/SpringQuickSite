package sylverwolf.mvcspring1.entity;

import lombok.Data;
import org.springframework.cache.interceptor.CacheAspectSupport;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by szkolenia on 2017-07-10.
 */
@Entity
@Data
@Table(name = "uzytkownicy")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imie;

    private String nazwisko;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private EmailAddress emailAddress;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "uzyt_samoch",
            joinColumns = {@JoinColumn(name ="id_user",referencedColumnName="id")},
            inverseJoinColumns = { @JoinColumn(name="id_samochod",referencedColumnName ="id")})
    private Car car;

    @Override
    public String toString() {
        return "User{imie=" +getImie()+ ", nazwisko="+getNazwisko()+"}";
    }

}

package sylverwolf.mvcspring1.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sylverwolf.mvcspring1.entity.CarType;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserVm {

     Integer id;
     String imie;
     String nazwisko;
     String adres;
     String ulica;
     String miasto;
     String nr_domu;
     String model;
     String marka;

     Integer id_adres;
     Integer id_marki;
     Integer id_emaila;
     Integer id_samochodu;
}

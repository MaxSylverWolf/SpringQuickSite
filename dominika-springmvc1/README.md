drop database ludziki;
create database ludziki;

use ludziki;

create table uzytkownicy(
id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
imie varchar(55),
nazwisko varchar(55));


create table samochod_marka(
id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
marka varchar(55));

create table samochody(
id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
model varchar(55),
id_marka int);

ALTER TABLE samochody ADD CONSTRAINT fk_model_id FOREIGN KEY (id_marka) REFERENCES samochod_marka(id);

create table uzyt_samoch(
id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
id_user int,
id_samochod int);

ALTER TABLE uzyt_samoch ADD CONSTRAINT fk_usersamo FOREIGN KEY(id_user) REFERENCES uzytkownicy(id);
ALTER TABLE uzyt_samoch ADD CONSTRAINT fk_samouser FOREIGN KEY(id_samochod) REFERENCES samochody(id);

create table email(
id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
id_user int,
adres varchar(55));

ALTER TABLE email ADD CONSTRAINT fk_user2_id FOREIGN KEY (id_user) REFERENCES uzytkownicy(id);

create table adres(
id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
id_user int,
ulica varchar(55),
nr_domu varchar(55),
miasto varchar(55));

ALTER TABLE adres ADD CONSTRAINT fk_user3_id FOREIGN KEY (id_user) REFERENCES uzytkownicy(id);

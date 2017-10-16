package sylverwolf.mvcspring1.converters;

import sylverwolf.mvcspring1.entity.Address;
import sylverwolf.mvcspring1.entity.Car;
import sylverwolf.mvcspring1.entity.CarType;
import sylverwolf.mvcspring1.entity.EmailAddress;
import sylverwolf.mvcspring1.entity.User;
import sylverwolf.mvcspring1.models.UserVm;

public class UserConverter {

    public static UserVm convertToVm(User user) {
        UserVm vm = new UserVm();

        if(user!=null) {
            vm.setId(user.getId());
            vm.setImie(user.getImie());
            vm.setNazwisko(user.getNazwisko());

            if (user.getEmailAddress() != null) {
                EmailAddress email = user.getEmailAddress();
                vm.setId_emaila(email.getId());
                vm.setAdres(email.getAdres());
            } else {
                vm.setId_emaila(null);
                vm.setAdres("");
            }

            if (user.getAddress() != null) {
                Address address = user.getAddress();
                vm.setId_adres(address.getId());
                vm.setUlica(address.getUlica());
                vm.setNr_domu(address.getNr_domu());
                vm.setMiasto(address.getMiasto());
            } else {
                vm.setId_adres(null);
                vm.setUlica("");
                vm.setNr_domu("");
                vm.setMiasto("");
            }

            if (user.getCar() != null) {
                Car car = user.getCar();
                vm.setId_samochodu(car.getId());
                vm.setModel(car.getModel());

                if(car.getCarType()!=null) {
                    CarType carType = car.getCarType();
                    vm.setId_marki(carType.getId());
                    vm.setMarka(carType.getMarka());
                }

            } else {
                vm.setId_samochodu(null);
                vm.setModel("");
                vm.setId_marki(null);
                vm.setMarka("");
            }
        }
        return vm;
    }

    public static User convertToEntity(UserVm vm) {
        User user = new User();

        if (vm !=null) {

            user.setId(vm.getId());
            user.setImie(vm.getImie());
            user.setNazwisko(vm.getNazwisko());

            EmailAddress emailAddress = new EmailAddress();
            emailAddress.setId(vm.getId_emaila());
            emailAddress.setAdres(vm.getAdres());

            Address address = new Address();
            address.setId(vm.getId_adres());
            address.setUlica(vm.getUlica());
            address.setNr_domu(vm.getNr_domu());
            address.setMiasto(vm.getMiasto());

            Car car = new Car();
            car.setId(vm.getId_samochodu());
            car.setModel(vm.getModel());

            CarType ct = new CarType();
            ct.setId(vm.getId_marki());
            ct.setMarka(vm.getMarka());

            user.setEmailAddress(emailAddress);
            emailAddress.setUser(user);

            user.setAddress(address);
            address.setUser(user);

            car.setCarType(ct);
            user.setCar(car);
            ct.setCar(car);
        }
        return user;
    }
}

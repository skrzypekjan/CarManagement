package pl.skrzypekjan.carmenagement;

import org.springframework.stereotype.Component;
import pl.skrzypekjan.carmenagement.dao.CarDao;


@Component
public class Start {

    private CarDao carDao;

    public Start(CarDao carDao) {
        this.carDao = carDao;
//        carDao.addCar(1, "Mercedes", "W123", "BLACK", 2006);
//        carDao.addCar(2, "Opel", "Vectra", "WHITE", 2010);
//        carDao.addCar(3, "Fiat", "Tipo", "GREEN", 2015);
//        carDao.addCar(4, "Ford", "Mondeo", "WHITE", 2012);
//        carDao.addCar(5, "Fiat", "Punto", "GREEN", 2014);

        carDao.findByProductionYear(2009, 2014).forEach(System.out::println);
    }
}

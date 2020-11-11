package pl.skrzypekjan.carmenagement.dao;

import pl.skrzypekjan.carmenagement.model.Car;

import java.util.List;

public interface CarDao {

    void addCar(String mark, String model, String color, long productionYear);

    void updateCar(Car newCar);

    void deleteCar(long id);

    List<Car> findAll();

    List<Car> findByProductionYear(int min, int max);
}

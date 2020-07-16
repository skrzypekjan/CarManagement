package pl.skrzypekjan.carmenagement.dao;

import org.springframework.stereotype.Component;
import pl.skrzypekjan.carmenagement.model.Car;
import pl.skrzypekjan.carmenagement.model.Color;

import java.util.List;

public interface CarDao {

    void addCar(long id, String mark, String model, Color color, int prodYear);

    void updateCar(Car newCar);

    void deleteCar(long id);

    List<Car> findAll();

    List<Car> findByProductionYear(int min, int max);
}

package pl.skrzypekjan.carmenagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.skrzypekjan.carmenagement.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCar(long id, String mark, String model, String color, int prodYear) {
        Car car = new Car(id, mark, model, color, prodYear);
        String sql = "INSERT INTO cars VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getCarId(), car.getMark(), car.getModel(), car.getColor(), car.getProductionYear());
    }

    @Override
    public void updateCar(Car newCar) {
        String sql = "UPDATE cars SET cars.mark=?, cars.model=?, cars.color=?, cars.production_year=? WHERE cars.car_id = ?";
        jdbcTemplate.update(sql, newCar.getMark(), newCar.getModel(), newCar.getColor(), newCar.getProductionYear(), newCar.getCarId());
    }

    @Override
    public void deleteCar(long id) {
        String sql = "DELETE FROM cars WHERE cars.car_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> carList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Long.parseLong(String.valueOf(element.get("production_year")))
        )));
        return carList;
    }

    @Override
    public List<Car> findByProductionYear(int min, int max) {
        List<Car> carListByYear = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE cars.production_year BETWEEN ? AND ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, min, max);
        maps.stream().forEach(element -> carListByYear.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Long.parseLong(String.valueOf(element.get("production_year")))
        )));
        return carListByYear;
    }
}

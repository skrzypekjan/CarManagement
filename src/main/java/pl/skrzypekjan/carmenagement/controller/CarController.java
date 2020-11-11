package pl.skrzypekjan.carmenagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.skrzypekjan.carmenagement.dao.CarDao;
import pl.skrzypekjan.carmenagement.model.Car;

@Controller
@RequestMapping
public class CarController {

    private final CarDao carDao;

    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showList(Model model, @RequestParam(name = "min",defaultValue = "1885") int min, @RequestParam( name = "max", defaultValue = "2099") int max){
        model.addAttribute("cars", carDao.findByProductionYear(min, max));
        model.addAttribute("newCar", new Car());
        return "list";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findByProductionYear(int min, int max) {
        return "redirect/:?min=" + min + "&max=" + max;
    }

    @RequestMapping(value = "/add-car", method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car) {
        carDao.addCar(car.getMark(), car.getModel(), car.getColor(), car.getProductionYear());
        return "redirect:/";
    }
}

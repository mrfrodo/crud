package no.frode.cruddemo.controller;

import no.frode.cruddemo.entity.Car;
import no.frode.cruddemo.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "Cars", value = "cars")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public List<Car> getAllCars() {
        logger.info("__getAllCars");
        return carService.getAllCars();
    }
}

package no.frode.cruddemo.controller;

import no.frode.cruddemo.entity.Car;
import no.frode.cruddemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {
    @Autowired
    private CarService carService;

    // GET Method for reading operation
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
}

package no.frode.cruddemo.service;

import no.frode.cruddemo.entity.Car;
import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarServiceTest {

    @InjectMocks
    CarService carService;

    @Mock
    CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProducts() {

        Set<String> uniqueNames = new HashSet<>(Arrays.asList("BMV", "Nissan", "Mercedes"));
        List<Car> carList = new ArrayList<>();
        uniqueNames.forEach(name ->
        {
            Car c = new Car();
            c.setCarName(name);
            carList.add(c);
        });

        when(carRepository.findAll()).thenReturn(carList);

        List<Car> carList1 = carService.getAllCars();

        verify(carRepository).findAll();

        assertEquals(3, carList1.size());
    }
}

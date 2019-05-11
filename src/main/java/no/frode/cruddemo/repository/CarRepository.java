package no.frode.cruddemo.repository;

import no.frode.cruddemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository  extends JpaRepository<Car,Long> {

}

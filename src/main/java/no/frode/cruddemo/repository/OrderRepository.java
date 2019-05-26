package no.frode.cruddemo.repository;

import no.frode.cruddemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Car,Long> {
}

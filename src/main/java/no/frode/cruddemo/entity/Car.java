package no.frode.cruddemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String carName;

    public void setCarName(String name) {
        this.carName = name;
    }

    public String getCarName() {
        return carName;
    }
}

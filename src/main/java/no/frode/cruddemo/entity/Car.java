package no.frode.cruddemo.entity;

import javax.persistence.*;

@Entity
@Table(name="cr_car")
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


package no.frode.cruddemo.entity;

import javax.persistence.*;

@Entity
@Table(name="cr_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String streetName;
    private String streetNumber;
}

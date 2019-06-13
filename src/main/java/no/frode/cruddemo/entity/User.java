package no.frode.cruddemo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cr_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String firstName;
    @ElementCollection
    private List<String> middleName = new ArrayList<>();
    private String lastName;
    @OneToMany
    private List<Address> addres;
}

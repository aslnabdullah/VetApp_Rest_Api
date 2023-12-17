package dev.patika.vetApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "mail",nullable = false,unique = true)
    private String mail;

    @Column(name = "adress",nullable = false)
    private String adress;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Animal> animalList;
}

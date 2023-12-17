package dev.patika.vetApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "species",nullable = false)
    private String species;

    @Column(name = "breed",nullable = false)
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",nullable = false)
    private GENDER gender;

    @Column(name = "colour",nullable = false)
    private String colour;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Vaccine> vaccineList;

    @OneToMany(mappedBy = "animal",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

    public enum GENDER{
        MALE , FEMALE
    }
}

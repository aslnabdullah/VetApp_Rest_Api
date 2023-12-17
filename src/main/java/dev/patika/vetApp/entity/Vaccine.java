package dev.patika.vetApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "code",nullable = false)
    private String code;

    @Column(name = "protectionStartDate", nullable = false)
    private LocalDate protectionStartDate;

    @Column(name = "protectionFinishDate", nullable = false)
    private LocalDate protectionFinishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id" , referencedColumnName = "id")
    private Animal animal;





}

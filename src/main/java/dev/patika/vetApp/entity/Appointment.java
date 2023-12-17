package dev.patika.vetApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "appointmentDate", nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id" , referencedColumnName = "id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id" , referencedColumnName = "id")
    private Doctor doctor;
}

package com.pharmamall.apothekendatenbank.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pharmamall.annotations.DomainModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "owner")
@Getter
@Setter
@NoArgsConstructor
@DomainModel
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Bitte den Vorname eingeben")
    @Column(nullable = false)
    private String firstName;

    @NotNull(message = "Bitte den Nachname eingeben")
    @Column(nullable = false)
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    @NotNull(message = "Bitte den Geburtsort eingeben")
    @Column(nullable = false)
    private LocalDate birthDate;

    @NotNull(message = "Bitte das Geburtsdatum eingeben")
    @Column(nullable = false)
    private String birthplace;


}

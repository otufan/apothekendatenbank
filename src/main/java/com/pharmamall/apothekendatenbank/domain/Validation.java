package com.pharmamall.apothekendatenbank.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pharmamall.annotations.DomainModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "validation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DomainModel
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pharmacy_id", referencedColumnName = "id")
    private Pharmacy pharmacyId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private LocalDate validationDate;

    @NotNull
    @Column(nullable = false)
    private Boolean validStatus = false;

    private String validatedBy;


}

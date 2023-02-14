package com.pharmamall.apothekendatenbank.domain;

import com.pharmamall.annotations.DomainModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pharmacy")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DomainModel
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Bitte den Apothekennamen eingeben")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Bitte die Straße und die Hausnummer eingeben")
    @Column(nullable = false)
    private String street;

    @Size(max = 5)
    @NotNull(message = "Bitte die Postleitzahl eingeben")
    @Column(nullable = false, length = 5)
    private String zip;

    @NotNull(message = "Bitte den Ort eingeben")
    @Column(nullable = false)
    private String city;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @NotNull(message = "Bitte die Telefonnummer eingeben")
    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Email(message = "Bitte die gültige Email eingeben")
    @NotNull(message = "Bitte die Email eingeben")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Boolean builtIn = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pharmacy_owner",
            joinColumns = @JoinColumn(name = "pharmacy_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<PharmacyGroup> owners = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pharmacy_pharmacyGroup",
            joinColumns = @JoinColumn(name = "pharmacy_id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacyGroup_id"))
    private Set<PharmacyGroup> pharmacyGroups = new HashSet<>();


}

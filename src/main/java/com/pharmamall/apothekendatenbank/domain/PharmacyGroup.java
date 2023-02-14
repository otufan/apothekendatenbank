package com.pharmamall.apothekendatenbank.domain;

import com.pharmamall.annotations.DomainModel;
import com.pharmamall.apothekendatenbank.domain.enumeration.PharmacyGroups;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "pharmacy_groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DomainModel
public class PharmacyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PharmacyGroups group;

    @Override
    public String toString() {
        return ""+ group + '}';
    }
}

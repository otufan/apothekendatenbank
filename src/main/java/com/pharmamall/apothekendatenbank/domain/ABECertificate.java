package com.pharmamall.apothekendatenbank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pharmamall.annotations.DomainModel;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "abe_certifikate")
@Getter
@Setter
@NoArgsConstructor
@DomainModel
public class ABECertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pharmacy_id", referencedColumnName = "id")
    private Pharmacy pharmacyId;

    private String name;

    @JsonIgnore
    @Lob
    private byte[] data;

    public ABECertificate(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
}

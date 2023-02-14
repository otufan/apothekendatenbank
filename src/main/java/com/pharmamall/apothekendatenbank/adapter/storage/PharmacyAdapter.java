package com.pharmamall.apothekendatenbank.adapter.storage;

import com.pharmamall.annotations.Adapter;
import com.pharmamall.apothekendatenbank.adapter.storage.repository.PharmacyRepository;
import com.pharmamall.apothekendatenbank.application.port.out.PharmacyPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Adapter("persistence")
public class PharmacyAdapter implements PharmacyPort {

    private final PharmacyRepository pharmacyRepository;



}

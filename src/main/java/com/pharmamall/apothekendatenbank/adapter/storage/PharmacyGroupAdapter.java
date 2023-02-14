package com.pharmamall.apothekendatenbank.adapter.storage;

import com.pharmamall.annotations.Adapter;
import com.pharmamall.apothekendatenbank.adapter.storage.repository.PharmacyGroupRepository;
import com.pharmamall.apothekendatenbank.application.port.out.PharmacyGroupPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Adapter("persistence")
public class PharmacyGroupAdapter implements PharmacyGroupPort {

    private final PharmacyGroupRepository pharmacyGroupRepository;
}

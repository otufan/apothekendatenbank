package com.pharmamall.apothekendatenbank.adapter.storage;

import com.pharmamall.annotations.Adapter;
import com.pharmamall.apothekendatenbank.adapter.storage.repository.OwnerRepository;
import com.pharmamall.apothekendatenbank.application.port.out.OwnerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Adapter("persistence")
public class OwnerAdapter implements OwnerPort {

    private final OwnerRepository ownerRepository;

}

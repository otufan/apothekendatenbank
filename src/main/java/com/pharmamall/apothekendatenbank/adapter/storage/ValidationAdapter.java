package com.pharmamall.apothekendatenbank.adapter.storage;

import com.pharmamall.annotations.Adapter;
import com.pharmamall.apothekendatenbank.adapter.storage.repository.ValidationRepository;
import com.pharmamall.apothekendatenbank.application.port.out.ValidationPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Adapter("persistence")
public class ValidationAdapter implements ValidationPort {

    private final ValidationRepository validationRepository;
}

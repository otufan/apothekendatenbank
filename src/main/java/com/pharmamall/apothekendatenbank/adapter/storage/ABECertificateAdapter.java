package com.pharmamall.apothekendatenbank.adapter.storage;

import com.pharmamall.annotations.Adapter;
import com.pharmamall.apothekendatenbank.adapter.storage.repository.ABECertificateRepository;
import com.pharmamall.apothekendatenbank.application.port.out.ABECertificatePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Adapter("persistence")
public class ABECertificateAdapter implements ABECertificatePort {

    private final ABECertificateRepository abeCertificateRepository;
}

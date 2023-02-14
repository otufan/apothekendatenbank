package com.pharmamall.apothekendatenbank.adapter.storage.repository;

import com.pharmamall.apothekendatenbank.domain.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ValidationRepository extends JpaRepository<Validation, Long> {
}

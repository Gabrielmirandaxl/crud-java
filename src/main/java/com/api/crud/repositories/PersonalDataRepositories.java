package com.api.crud.repositories;

import com.api.crud.models.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PersonalDataRepositories extends JpaRepository<PersonalData, UUID> {

    boolean existsByEmailUser(String emailUser);
    boolean existsByCelularUser(String celularUser);
}

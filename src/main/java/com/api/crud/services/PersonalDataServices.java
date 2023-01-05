package com.api.crud.services;

import com.api.crud.models.PersonalData;
import com.api.crud.repositories.PersonalDataRepositories;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonalDataServices {

    final PersonalDataRepositories personalDataRepositories;

    public PersonalDataServices(PersonalDataRepositories personalDataRepositories){
        this.personalDataRepositories = personalDataRepositories;
    }

    //services
    @Transactional
    public PersonalData save(PersonalData personalDataModel){
        return personalDataRepositories.save(personalDataModel);
    }

    public List<PersonalData> findAll(){
        return personalDataRepositories.findAll();
    }

    @Transactional
    public Optional<PersonalData> findById(UUID id){
        return personalDataRepositories.findById(id);
    }

    public void deleteById(PersonalData personalDataModel){
    personalDataRepositories.delete(personalDataModel);
    }


    //validations
    public boolean existsByEmailUser(String emailUser){
        return  personalDataRepositories.existsByEmailUser(emailUser);
    }

    public boolean existsByCelularUser(String celularUser){
        return personalDataRepositories.existsByCelularUser(celularUser);
    }
}

package com.api.crud.controllers;

import com.api.crud.dtos.PersonalDataDto;
import com.api.crud.models.PersonalData;
import com.api.crud.services.PersonalDataServices;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/personalData")
public class PersonalDataController {

    final PersonalDataServices personalDataServices;

    public PersonalDataController(PersonalDataServices personalDataServices){
        this.personalDataServices = personalDataServices;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid PersonalDataDto personalDataDto){
        if(personalDataServices.existsByEmailUser(personalDataDto.getEmailUser())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Use another email");
        }

        if(personalDataServices.existsByCelularUser(personalDataDto.getCelularUser())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("use another tel");
        }

        var personalDataModel = new PersonalData();
        BeanUtils.copyProperties(personalDataDto, personalDataModel);
        personalDataModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(personalDataServices.save(personalDataModel));
    }

    @GetMapping
    public ResponseEntity<List<PersonalData>> getAllPersonalData(){
        return  ResponseEntity.status(HttpStatus.OK).body(personalDataServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id){
        Optional<PersonalData> personalDataOptional = personalDataServices.findById(id);
        if(!personalDataOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(personalDataOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOneUser(@PathVariable(value = "id") UUID id){
        Optional<PersonalData> personalDataOptional = personalDataServices.findById(id);

        if(!personalDataOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }

        personalDataServices.deleteById(personalDataOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("deleted sucess");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOndeUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid PersonalDataDto personalDataDto){
        Optional<PersonalData> personalDataOptional = personalDataServices.findById(id);
        if(!personalDataOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
        var personalDataModel =  personalDataOptional.get();
        personalDataModel.setNameUser(personalDataDto.getNameUser());
        personalDataModel.setEmailUser(personalDataDto.getEmailUser());
        personalDataModel.setCelularUser(personalDataDto.getCelularUser());
        personalDataModel.setNotaUser(personalDataDto.getNotaUser());

        return ResponseEntity.status(HttpStatus.OK).body(personalDataServices.save(personalDataModel));

    }

}

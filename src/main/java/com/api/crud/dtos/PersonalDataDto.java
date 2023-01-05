package com.api.crud.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonalDataDto {

    @NotBlank
    @Size(max = 20)
    private String nameUser;
    @NotBlank
    @Size(max = 20)
    @Email()
    private String emailUser;
    @NotBlank
    @Size(max = 15)
    private String celularUser;
    @NotBlank
    @Size(max = 9)
    private String cepUser;
    @NotNull
    private double notaUser;

    public double getNotaUser() {
        return notaUser;
    }

    public void setNotaUser(double notaUser) {
        this.notaUser = notaUser;
    }



    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getCelularUser() {
        return celularUser;
    }

    public void setCelularUser(String celularUser) {
        this.celularUser = celularUser;
    }

    public String getCepUser() {
        return cepUser;
    }

    public void setCepUser(String cepUser) {
        this.cepUser = cepUser;
    }




}

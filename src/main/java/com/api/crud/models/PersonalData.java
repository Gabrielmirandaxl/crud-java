package com.api.crud.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class PersonalData implements Serializable {
   private  static final long serialVersionUID = 1L;


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;
   @Column(nullable = false, length = 20)
   private String nameUser;
   @Column(nullable = false, unique = true, length = 20)
   private String emailUser;
   @Column(nullable = false, unique = true, length = 15)
   private String celularUser;
   @Column(nullable = false,  length = 9)
   private String cepUser;
   @Column(nullable = false)
   private LocalDateTime registrationDate;
   @Column(nullable = false)
   private double notaUser;

   public double getNotaUser() {
      return notaUser;
   }

   public void setNotaUser(double notaUser) {
      this.notaUser = notaUser;
   }

   public LocalDateTime getRegistrationDate() {
      return registrationDate;
   }

   public void setRegistrationDate(LocalDateTime registrationDate) {
      this.registrationDate = registrationDate;
   }

   public UUID getId() {
      return id;
   }

   public void setId(UUID id) {
      this.id = id;
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

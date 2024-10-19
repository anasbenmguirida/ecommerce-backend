package com.example.demo.CommandeDetails;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CommandeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id ; 
private int userId ; 
private int productId ; 
private  int quantity ; 
private double price ; 
@JsonFormat(pattern = "MM/dd/yyyy")
private LocalDate dateReservation ;



}

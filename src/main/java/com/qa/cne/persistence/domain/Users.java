package com.qa.cne.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Users {

    // variables

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column
    private String FirstName; // first name

    @Column
    private String LastName; // last name
    
    @Column
    private String PassportNumber; //ppn
    
    public Users(String FirstName, String LastName, String PassportNumber) {
        super();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PassportNumber = PassportNumber;
        
    }
    



    
}
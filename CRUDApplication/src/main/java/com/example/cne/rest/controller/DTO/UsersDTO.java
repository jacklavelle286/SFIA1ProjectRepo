package com.example.cne.rest.controller.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersDTO {
//this stands for data transfer object - makes data readable to end user
	
	private Long id;
	private String firstName;
	private String lastName;
	private String passportNumber;

}

package com.example.CRM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class LoginResponse {

	private Long id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;

	private Long phone;
	private String gender;
	private String city;
	private Long zipcode;
	private String fulladress;
	private Date birthdate;
	private Long cin;
	private Integer accountstatus; //0 = deleted / 1 = active / 2 = suspended
	private Date createdat;
	private Date updatedat;
	private List<String> roles;

	public LoginResponse(Long id, String firstname, String lastname, String username, String email, Long phone, String gender, String city, Long zipcode, String fulladress, Date birthdate, Long cin, Integer accountstatus, Date createdat, Date updatedat, List<String> roles) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;

		this.phone = phone;
		this.gender = gender;
		this.city = city;
		this.zipcode = zipcode;
		this.fulladress = fulladress;
		this.birthdate = birthdate;
		this.cin = cin;
		this.accountstatus = accountstatus;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.roles = roles;
	}
}

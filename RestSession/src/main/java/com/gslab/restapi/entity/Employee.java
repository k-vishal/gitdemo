package com.gslab.restapi.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="Employee")
@Data
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="_id")
	private Long id;
	private String city;
	private String firstName;
	private String lastName;

	public Employee() {
	}

}
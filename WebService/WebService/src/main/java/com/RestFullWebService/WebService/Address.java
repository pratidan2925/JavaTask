package com.RestFullWebService.WebService;

import jakarta.persistence.*;

@Entity
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

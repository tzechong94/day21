package com.example.workshop21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    private Integer id;
    private String company;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String jobTitle;
    private String businessPhone;
    private String homePhone;
    private String mobilePhone;
    private String faxNumber;
    private String address;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String countryRegion;
    private String webPage;
    private String notes;
    private byte[] attachments;

}

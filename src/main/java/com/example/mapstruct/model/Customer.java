package com.example.mapstruct.model;

import lombok.*;

import java.util.Date;

/**
 * @author z.Taghizadeh
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer {

    private String customerId;

    private String firstName;

    private String lastName;

    private Integer birthDate;

    private Date startDt;

    private CustomerType customerType;


}

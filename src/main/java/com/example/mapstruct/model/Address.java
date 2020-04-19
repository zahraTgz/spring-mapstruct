package com.example.mapstruct.model;

import lombok.*;

/**
 * @author z.Taghizadeh
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Address {

    private String street;

    private String postalCode;

    private String county;
}

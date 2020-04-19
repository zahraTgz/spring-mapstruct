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
public class DeliveryAddress {

    private String forename;

    private String surname;

    private String street;

    private String postalCode;

    private String county;
}

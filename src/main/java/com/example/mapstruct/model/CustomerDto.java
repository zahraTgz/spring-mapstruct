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
public class CustomerDto {

    private String forename;

    private String lastName;

    private String birthDate;

    private String customerStartDt;

    private String customerType;
}

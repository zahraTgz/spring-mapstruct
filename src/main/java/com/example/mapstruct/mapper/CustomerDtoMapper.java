package com.example.mapstruct.mapper;

import com.example.mapstruct.model.Address;
import com.example.mapstruct.model.Customer;
import com.example.mapstruct.model.CustomerDto;
import com.example.mapstruct.model.DeliveryAddress;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

/**
 * @author z.Taghizadeh
 */
@Mapper(imports = UUID.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        componentModel = "spring")
public interface CustomerDtoMapper {

    @Mappings({
            @Mapping(target = "forename", source = "firstName"),
            @Mapping(target = "birthDate", source = "birthDate",
                    qualifiedByName = "convertToStringDate"),
            @Mapping(target = "customerStartDt", source = "customer.startDt",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    CustomerDto fromCustomerToDto(Customer customer);

    List<CustomerDto> fromCustomerListToDtoList(List<Customer> customer);

    @Mappings({
            @Mapping(source = "customer.firstName", target = "forename"),
            @Mapping(source = "customer.lastName", target = "surname"),
            @Mapping(source = "address.street", target = "street"),
            @Mapping(source = "address.postalCode", target = "postalCode"),
            @Mapping(source = "address.county", target = "county")
    })
    DeliveryAddress from(Customer customer, Address address);

    @Mappings({
            @Mapping(source = "forename", target = "firstName"),
            @Mapping(source = "birthDate", target = "birthDate",
                    qualifiedByName = "convertToNumberDate"),
            @Mapping(target = "startDt", source = "customerDto.customerStartDt",
                    dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="customerId",expression="java( UUID.randomUUID().toString() )")
    })
    Customer fromCustomerDoToCustomer(CustomerDto customerDto);

    List<Customer> fromCustomerDoListToCustomerList(List<CustomerDto> customerDto);


    @Named("convertToStringDate")
    default String addSlashToDate(Integer dateInt) {

        String dateString = dateInt.toString();
        if (dateInt.toString().length() == 8) {
            String year = dateString.substring(0, 4).concat("/");
            String mm = dateString.substring(4, 6).concat("/");
            String dd = dateString.substring(6, 8);
            return year + mm + dd;
        } else {
            return "";
        }
    }

    @Named("convertToNumberDate")
    default Integer removeSlashFromDate(String dateStr) {
        return Integer.parseInt(dateStr.replaceAll("/", ""));
    }
}

package com.example.mapstruct;

import com.example.mapstruct.mapper.CustomerDtoMapper;
import com.example.mapstruct.model.Customer;
import com.example.mapstruct.model.CustomerDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

/**
 * @author z.Taghizadeh
 */
public class CustomerTest {

    @Test
    public void givenCustomerDtoToCustomer() {
        CustomerDtoMapper customerDtoMapper = Mappers.getMapper(CustomerDtoMapper.class);

        CustomerDto entity = new CustomerDto();
        entity.setForename("zahra");
        entity.setLastName("tgz");
        entity.setBirthDate("1399/01/20");
        entity.setCustomerStartDt("19-04-2020 14:20:18");
        entity.setCustomerType("VIP");
        Customer customer = customerDtoMapper.fromCustomerDoToCustomer(entity);

        System.out.println(customer.toString());
    }
}

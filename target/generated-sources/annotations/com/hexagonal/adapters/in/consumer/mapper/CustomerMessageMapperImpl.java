package com.hexagonal.adapters.in.consumer.mapper;

import com.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T16:27:06-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CustomerMessageMapperImpl implements CustomerMessageMapper {

    @Override
    public Customer toCustomer(CustomerMessage customerMessage) {
        if ( customerMessage == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerMessage.getId() );
        customer.setName( customerMessage.getName() );
        customer.setCpf( customerMessage.getCpf() );
        customer.setIsValidCpf( customerMessage.getIsValidCpf() );

        return customer;
    }
}

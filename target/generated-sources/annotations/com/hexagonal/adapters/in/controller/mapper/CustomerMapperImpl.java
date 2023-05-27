package com.hexagonal.adapters.in.controller.mapper;

import com.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.hexagonal.adapters.in.controller.response.AddressResponse;
import com.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.hexagonal.application.core.domain.Address;
import com.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T16:27:06-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerRequest.getName() );
        customer.setCpf( customerRequest.getCpf() );

        return customer;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId( customer.getId() );
        customerResponse.setName( customer.getName() );
        customerResponse.setAddress( addressToAddressResponse( customer.getAddress() ) );
        customerResponse.setCpf( customer.getCpf() );
        customerResponse.setIsValidCpf( customer.getIsValidCpf() );

        return customerResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setStreet( address.getStreet() );
        addressResponse.setCity( address.getCity() );
        addressResponse.setState( address.getState() );

        return addressResponse;
    }
}

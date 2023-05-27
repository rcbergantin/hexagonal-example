package com.hexagonal.adapters.out.repository.mapper;

import com.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.hexagonal.adapters.out.repository.entity.CustomerEntity;
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
public class CustomerEntityMapperImpl implements CustomerEntityMapper {

    @Override
    public CustomerEntity toCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customer.getId() );
        customerEntity.setName( customer.getName() );
        customerEntity.setAddress( addressToAddressEntity( customer.getAddress() ) );
        customerEntity.setCpf( customer.getCpf() );
        customerEntity.setIsValidCpf( customer.getIsValidCpf() );

        return customerEntity;
    }

    @Override
    public Customer toCustumer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerEntity.getId() );
        customer.setName( customerEntity.getName() );
        customer.setAddress( addressEntityToAddress( customerEntity.getAddress() ) );
        customer.setCpf( customerEntity.getCpf() );
        customer.setIsValidCpf( customerEntity.getIsValidCpf() );

        return customer;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setStreet( address.getStreet() );
        addressEntity.setCity( address.getCity() );
        addressEntity.setState( address.getState() );

        return addressEntity;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressEntity.getStreet() );
        address.setCity( addressEntity.getCity() );
        address.setState( addressEntity.getState() );

        return address;
    }
}

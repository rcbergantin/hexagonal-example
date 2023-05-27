package com.hexagonal.adapters.out.client.mapper;

import com.hexagonal.adapters.out.client.response.AddressResponse;
import com.hexagonal.application.core.domain.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T16:27:06-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class AddressResponseMapperImpl implements AddressResponseMapper {

    @Override
    public Address toAddress(AddressResponse addressResponse) {
        if ( addressResponse == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressResponse.getStreet() );
        address.setCity( addressResponse.getCity() );
        address.setState( addressResponse.getState() );

        return address;
    }
}

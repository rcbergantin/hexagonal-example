package com.hexagonal.application.ports.out;

import com.hexagonal.application.core.domain.Address;

public interface FindAddressZipCodeOutputPort {

    Address find (String zipCode);
}

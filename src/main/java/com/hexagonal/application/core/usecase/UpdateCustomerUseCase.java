package com.hexagonal.application.core.usecase;

import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.hexagonal.application.ports.out.FindAddressZipCodeOutputPort;
import com.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressZipCodeOutputPort findAddressZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressZipCodeOutputPort findAddressZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressZipCodeOutputPort = findAddressZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {

        findCustomerByIdInputPort.find((customer.getId()));
        var address = findAddressZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);

    }

}

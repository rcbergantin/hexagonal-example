package com.hexagonal.application.core.usecase;

import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.hexagonal.application.ports.out.FindAddressZipCodeOutputPort;
import com.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private  final FindAddressZipCodeOutputPort findAddressZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressZipCodeOutputPort findAddressZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressZipCodeOutputPort = findAddressZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}

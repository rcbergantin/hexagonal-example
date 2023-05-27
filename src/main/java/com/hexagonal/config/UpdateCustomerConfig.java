package com.hexagonal.config;

import com.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import com.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUserCase findCustomerByIdUserCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUserCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}

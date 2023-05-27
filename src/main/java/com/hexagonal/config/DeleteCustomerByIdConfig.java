package com.hexagonal.config;

import com.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUserCase findCustomerByIdUserCase, DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUserCase, deleteCustomerByIdAdapter);
    }

}

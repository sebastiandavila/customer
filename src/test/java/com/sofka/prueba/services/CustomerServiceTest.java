package com.sofka.prueba.services;

import com.sofka.prueba.entities.Customer;
import com.sofka.prueba.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testCreateCustomer() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Sebastian Davila");

        when(customerRepository.save(customer)).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertEquals(customer.getId(), createdCustomer.getId());
        assertEquals(customer.getName(), createdCustomer.getName());
    }

    @Test
    public void testGetCustomerById() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Isa Ruiz");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer foundCustomer = customerService.getCustomerById(1L);


        assertEquals(customer.getId(), foundCustomer.getId());
        assertEquals(customer.getName(), foundCustomer.getName());
    }
}
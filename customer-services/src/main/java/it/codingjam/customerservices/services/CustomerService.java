package it.codingjam.customerservices.services;

import it.codingjam.customerservices.dtos.Customer;
import it.codingjam.customerservices.dtos.Customers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RefreshScope
public class CustomerService {

    @Value("${default.company.id}")
    private String defaultCompanyId;

    public Customers getAll() {
        List<Customer> customers = Arrays.asList(new Customer(1, "Andrea Como"), new Customer(2, "Mario Rossi"));
        return new Customers(defaultCompanyId, customers);
    }
}

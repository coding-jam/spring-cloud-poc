package it.codingjam.customerservices.dtos;

import java.util.List;

public class Customers {

    private List<Customer> customers;

    public Customers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

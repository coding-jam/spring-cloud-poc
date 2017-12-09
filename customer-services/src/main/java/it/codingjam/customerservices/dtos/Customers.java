package it.codingjam.customerservices.dtos;

import java.util.List;

public class Customers {

    private String defaultCompanyId;

    private List<Customer> customers;

    public Customers(String defaultCompanyId, List<Customer> customers) {
        this.defaultCompanyId = defaultCompanyId;
        this.customers = customers;
    }

    public String getDefaultCompanyId() {
        return defaultCompanyId;
    }

    public void setDefaultCompanyId(String defaultCompanyId) {
        this.defaultCompanyId = defaultCompanyId;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

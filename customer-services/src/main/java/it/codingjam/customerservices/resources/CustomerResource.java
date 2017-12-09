package it.codingjam.customerservices.resources;

import it.codingjam.customerservices.dtos.Customer;
import it.codingjam.customerservices.dtos.Customers;
import it.codingjam.customerservices.services.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET
    public Customers getAll() {
        return customerService.getAll();
    }

    @GET
    @Path("/{id}")
    public Customer getById(@PathParam("id") Long id) {
        return customerService.getAll().getCustomers().stream()
                .filter(c -> id.equals(c.getId()))
                .findAny()
                .orElseThrow(NotFoundException::new);
    }
}

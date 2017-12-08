package it.codingjam.customerservices.resources;

import it.codingjam.customerservices.dtos.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/v1/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @GET
    public List<Customer> getAll() {
        return Arrays.asList(new Customer(1, "Andrea Como"), new Customer(2, "Mario Rossi"));
    }
}

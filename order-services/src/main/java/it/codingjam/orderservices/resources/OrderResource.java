package it.codingjam.orderservices.resources;

import it.codingjam.orderservices.dtos.Orders;
import it.codingjam.orderservices.services.OrderService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/customers/{id}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    private OrderService orderService;

    @GET
    public Response getOrders(@PathParam("id") Long customerId) {
        Orders customerOrders = orderService.getCustomerOrders(customerId);
        return Response.ok(customerOrders).build();
    }
}

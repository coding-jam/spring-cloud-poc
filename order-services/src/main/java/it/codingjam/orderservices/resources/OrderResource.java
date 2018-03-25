package it.codingjam.orderservices.resources;

import it.codingjam.orderservices.dtos.Orders;
import it.codingjam.orderservices.services.OrderService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/v1/customers/{id}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private static final Logger LOGGER = Logger.getLogger(OrderResource.class.getName());

    @Inject
    private OrderService orderService;

    @GET
    public Response getOrders(@PathParam("id") Long customerId) {
        LOGGER.log(Level.INFO, "Searching orders for customer id {0}", customerId);
        Orders customerOrders = orderService.getCustomerOrders(customerId);
        return Response.ok(customerOrders).build();
    }

    @GET
    @Path("/exception")
    public Response generateException(@PathParam("id") Long customerId) {
        throw new IllegalArgumentException("Example stacktrace for ELK");
    }
}

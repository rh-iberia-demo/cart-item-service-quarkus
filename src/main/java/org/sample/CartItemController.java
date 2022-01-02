package org.sample;

import java.util.UUID;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.openapi.annotations.Operation;

import org.jboss.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cart-item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartItemController {

    @Inject
    Logger log;

    @Inject
    CartItemRepository cartItemRepository;

    @GET
    @Operation(summary = "Get Cart Items",description = "Get a list of Cart Items")    
    public List<CartItem> list() {
        return CartItem.listAll();
    }
	
    @GET
    @Path("{id}")
    @Operation(summary = "Get Cart Item",description = "Get a Cart Item by id")    
	public CartItem get(@PathParam("id") String id) { 	
        return cartItemRepository.findById(id);
    }

    @PUT
    @Operation(summary = "Create a Cart Item", description = "Create a Cart Item serialized in JSON")
    @Transactional public Response put(CartItem ci) {

        ci.setId(UUID.randomUUID().toString());
    //    log.info(ci);

        cartItemRepository.persist(ci);
        
        return Response.created(URI.create("/cart-item/" + ci.getId())).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete a Cart Item", description = "Delete a Cart Item by id")
    @Transactional public void deleteCartItem(@PathParam("id") String id) {
        CartItem entity = CartItem.findById(id);
        
        if(entity == null) {
            throw new NotFoundException();
        }
 
        CartItem.delete("id",id);
    }

    @POST
    @Path("{id}")
    @Operation(summary = "Update a Cart Item", description = "Update a Cart Item by id")
    @Transactional public CartItem updateCartItem(@PathParam("id") String id, CartItem ci) {
    
        CartItem entity = CartItem.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the person parameter to the existing entity
        entity.setQuantity(ci.getQuantity());
        entity.setOriginCatalog(ci.getOriginCatalog());
        entity.setFinalPrice(ci.getFinalPrice());

        return entity;

    }

}
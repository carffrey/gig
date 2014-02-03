package com.carffrey.rest.resource;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import com.carffrey.model.Venue;

@Stateless
@LocalBean
@Path("/venues")
public class VenueResource {

    @PersistenceContext
    EntityManager em;
    
    @Context
    private UriInfo uriInfo;
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{id}")
    public Venue read(@Context SecurityContext sc, @PathParam("id") long id) {
        return em.find(Venue.class, id);
    }
    
	@POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response create(@Context SecurityContext sc, Venue venue) {
		venue = em.merge(venue);
		return Response.ok(venue).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@Context SecurityContext sc, @PathParam("id") long id) {
		Venue venue = read(sc, id);
		em.remove(venue);
		return Response.ok(venue).build();
	}
 }

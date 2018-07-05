package com.spring.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.spring.restws.model.Passenger;

@Path(value = "/passengerservice")
@Produces("application/xml,application/json")
@Consumes("application/xml,application/json,application/x-www-form-urlencoded")
public interface PassengerService 
{
	@Path("/passengers")
	@GET
	List<Passenger> getPassengers(@QueryParam("start")int start, @QueryParam("size")int size);
	
	@Path("/passengers")
	@POST
	Passenger addPassenger(@FormParam("firstName")String firstName, @FormParam("lastName")String lastName, @HeaderParam("agent") String agent,@Context HttpHeaders headers);
	
}

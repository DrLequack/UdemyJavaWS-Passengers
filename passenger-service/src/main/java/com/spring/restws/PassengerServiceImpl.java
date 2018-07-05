package com.spring.restws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.spring.restws.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();
	long id = 100L;
	
	public PassengerServiceImpl()
	{
		init();
	}
	
	@Override
	public List<Passenger> getPassengers(int start, int size) 
	{
		if(start + 1 > passengers.size())
		{
			throw new WebApplicationException(Response.Status.NO_CONTENT);
		}
		
		if(size <= 0 && start < 0)
		{
			return passengers;
		}
		
		if(size <= 0 && start >= 0 || start + size > passengers.size())
		{
			return passengers.subList(start, passengers.size());
		}
	
		return passengers.subList(start, start + size);
		
	}

	@Override
	public Passenger addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) 
	{
		System.out.println("Agent: " + agent);
		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		for (Map.Entry<String, List<String>> entry : requestHeaders.entrySet()) 
		{
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println("Cookies====================");
		Map<String, Cookie> cookies = headers.getCookies();
		for (String key : cookies.keySet()) 
		{
			System.out.println(key + " " + cookies.get(key).getValue());
		}
		
		Passenger p = new Passenger();
		p.setId(id++);
		p.setName(firstName + " " + lastName);
		passengers.add(p);
		return p;
	}
	
	private void init()
	{
		Passenger p;
		for(int i = 1; i<=100; i++)
		{
			p = new Passenger();
			p.setId(id++);
			p.setName(RandomNames.getRandomName());
			passengers.add(p);
		}
	}

}

package com.cgi.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

/**
 * This class is used to manage user authentication and details.
 * 
 * @author Prateep Gedupudi
 */
@Path("/v1/user")
public class UserService {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String userData(){
		
		return "Prateep Gedupudi";
	}

}

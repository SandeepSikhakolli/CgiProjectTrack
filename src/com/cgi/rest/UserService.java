package com.cgi.rest;

import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

/**
 * This class is used to manage user authentication and details.
 * 
 * @author Prateep Gedupudi
 */
@Path("/v1/user")
public class UserService {
	
	/**
     * This method will authenticate the user and return response with cookie for next requests.
     * 
     * /api/v1/user/login
     * 
     * @param email - email id
     * @param password - password
     * @return - response with cookie
     */
	@Path("/login")
	@POST
	public Response login(@FormParam("email") String email,
	        @FormParam("password") String password) {
	    
	    //TODO: authenticate email and password and generate accessToken with some algorithm and return as cookie.  
	    return Response.ok().cookie(new NewCookie("accessToken", "ABCDGFTYPUIYO")).build();
	}

}

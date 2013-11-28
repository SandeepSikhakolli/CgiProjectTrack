package com.cgi.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.cgi.dao.MySqlDao;
import com.cgi.dao.SchemaCgiTask;

/**
 * This class is used to manage tasks.
 * 
 * @author Prateep Gedupudi
 */

@Path("/v1/task")
public class TaskService {
	/**
     * This method will return the specific tasks to user.
     * 
     * /api/v1/task?user=prateep
     * 
     * @param user - username
     * @return - json array results list from the database
     * @throws Exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnTasks(
                            @QueryParam("user") String user)
                            throws Exception {
            
            String returnString = null;
            JSONArray json = new JSONArray();
            
            
            try {
                    
                    //return a error is user is missing from the url string
                    if(user == null) {
                            return Response.status(400).entity("Error: please specify user for this search").build();
                    }
                    
                    
                    SchemaCgiTask dao=new SchemaCgiTask();
                    
                    
                    json = dao.queryReturnTasks(user);
                    returnString = json.toString();
                    
            }
            catch (Exception e) {
                    e.printStackTrace();
                    return Response.status(500).entity("Server was not able to process your request").build();
            }
            
            return Response.ok(returnString).build();
    }

}

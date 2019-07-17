package com.sumerge.program;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("Users")

public class UserResources {
    private static final Logger LOGGER = Logger.getLogger(UserResources.class.getName());
    private Users users;
    @Context
    HttpServletRequest request;

    @GET
    public Response getAllUsers() {
        try {
            return Response.ok().
                    entity(users.ShowAll()).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getUserByID(@QueryParam("id") String id) {
        try {

            return Response.ok().
                    entity(users.SearchUserById(id)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getUserByName(@QueryParam("name") String name) {
        try {

            return Response.ok().
                    entity(users.SearchUserByName(name)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
    @GET
    public Response getUserByAdress(@QueryParam("adress") String adress) {
        try {

            return Response.ok().
                    entity(users.SearchUserByAdress(adress)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @GET
    public Response getUserByEmail(@QueryParam("email") String email) {
        try {

            return Response.ok().
                    entity(users.SearchUserByEmail(email)).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }
    @POST
    public Response addUser(User user) {
        try {
            if (user.getID() != null)
                throw new IllegalArgumentException("Can't create user since it exists in the database");

            User merged = (User) users.AddUser(user.getID(),user.getName(),user.getAdress(),user.getEmail());
            URI uri = new URI(request.getRequestURI() + merged.getID());
            return Response.created(uri).
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @PUT
    public Response editUser (User user) {
        try {
            if (user.getID() == null)
                throw new IllegalArgumentException("Can't edit User since it does not exist in the database");

            users.UpdateUser(user.getID(),user.getName(),user.getEmail(),user.getAdress());
            return Response.ok().
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

    @DELETE
    public Response deleteUser(@QueryParam("id") String id) {
        try {
            users.DeleteUserById(id);
            return Response.ok().
                    build();
        } catch (Exception e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            return Response.serverError().
                    entity(e.getClass() + ": " + e.getMessage()).
                    build();
        }
    }

}

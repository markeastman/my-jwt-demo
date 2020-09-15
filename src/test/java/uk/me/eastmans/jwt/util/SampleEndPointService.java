package uk.me.eastmans.jwt.util;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

@Path("/Sample")
public interface SampleEndPointService {
    @GET
    @Path("/helloworld")
    String helloworld();

    @GET()
    @Path("/subscription")
    String helloRolesAllowed(@HeaderParam("Authorization") String authHeaderValue);

    @GET()
    @Path("/birthday")
    String birthday(@HeaderParam("Authorization") String authHeaderValue);
}
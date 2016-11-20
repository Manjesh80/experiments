package com.manjesh.network.ers;

import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static javax.validation.executable.ExecutableType.GETTER_METHODS;

/**
 * Created by aadhya on 11/19/2016.
 */

@Path("ers")
@ValidateOnExecution( type = ExecutableType.ALL)
public class EventReceiverService {

    private Map<Integer, VirtualNetworkEvent> devices = new
            HashMap<Integer, VirtualNetworkEvent>();

    public EventReceiverService() {
        devices.put(new Integer(1), new VirtualNetworkEvent(1, "First Device"));
        devices.put(new Integer(2), new VirtualNetworkEvent(2, "Second Device"));
        devices.put(new Integer(3), new VirtualNetworkEvent(3, "Third Device"));
        devices.put(new Integer(4), new VirtualNetworkEvent(4, "Fourth Device"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response addEvent(VirtualNetworkEvent event) {
        return Response.ok(event).type(MediaType.APPLICATION_XML_TYPE).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/device/{deviceId}")
    @NotNull(message = "Device ID cannot be Null")
    public Response getEvent(@PathParam("deviceId") Integer deviceId, @Context UriInfo uriInfo)  {
        try {
            System.out.println("Ganesh URI Info ==> " + uriInfo.getRequestUri().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return Response.ok(devices.get(deviceId)).type(MediaType.APPLICATION_XML).build();
        //return Response.ok(new VirtualNetworkEvent(" 1","Ganesh 2")).type(MediaType.APPLICATION_XML_TYPE).build();
        //return Response.ok("{ 'Jai' : 'Ganesh'}").type(MediaType.TEXT_HTML).build();
    }
}


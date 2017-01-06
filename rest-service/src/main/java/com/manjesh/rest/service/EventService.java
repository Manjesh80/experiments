package com.manjesh.rest.service;

import com.manjesh.rest.model.Event;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 1/6/2017.
 */

@Path("/event")
public class EventService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> GetEvents() {
        return Arrays.asList(
                new Event("Device-1", "Network-1", OffsetDateTime.now()),
                new Event("Device-2", "Network-2", OffsetDateTime.now().plusDays(2))
        );
    }
}

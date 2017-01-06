package com.manjesh.rest.service;

import com.manjesh.rest.model.Event;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
        return DataSource.GetEvents();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public List<Event> AddEvent(Event newEvent) {
        return DataSource.AddEvent(newEvent);
    }

    static class DataSource {
        static List<Event> events;

        static {
            events = new LinkedList<>();
            events.add(new Event("Device-1", "Network-1", OffsetDateTime.now()));
            events.add(new Event("Device-2", "Network-2", OffsetDateTime.now().plusDays(2)));
        }

        static public List<Event> AddEvent(Event event) {
            System.out.println(" ******* Adding event now ********");
            if (null == event)
                System.out.println(" ******* NULL NULL NULL NULL ********");
            else
                System.out.println(event.getDeviceID());

            events.add(event);
            return events;
        }

        static public List<Event> GetEvents() {
            return events;
        }
    }
}

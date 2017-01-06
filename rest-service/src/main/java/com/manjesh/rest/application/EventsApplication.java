package com.manjesh.rest.application;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 1/6/2017.
 */

import com.manjesh.rest.service.EventService;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@ApplicationPath("ers")
public class EventsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> handlers = new HashSet<>();
        handlers.add(EventService.class);
        return handlers;
    }
}

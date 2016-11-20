package com.manjesh.network.ers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aadhya on 11/19/2016.
 */

@ApplicationPath("/")
public class GlobalEventCollectorApplication extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(EventReceiverService.class);
        classes.add(VirtualNetworkEventSerializer.class);
        return classes;
    }
}













































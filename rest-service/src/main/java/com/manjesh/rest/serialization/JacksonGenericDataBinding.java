package com.manjesh.rest.serialization;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.manjesh.rest.model.Event;

import java.io.IOException;


public class JacksonGenericDataBinding {

  /*  public static void main(String[] args) throws IOException {
        JacksonGenericDataBinding jacksonGenericDataBinding = new JacksonGenericDataBinding();
        jacksonGenericDataBinding.deserializeEvent();
    }

    public void deserializeEvent() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        Event event = objectMapper.readValue(getClass().getResourceAsStream("/event.json"), Event.class);
        System.out.println("Event ID ==>" + event.getDeviceID());
    }*/
}


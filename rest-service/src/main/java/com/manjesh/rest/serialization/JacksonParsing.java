package com.manjesh.rest.serialization;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.manjesh.domain.model.NetworkEvent;

import java.io.IOException;
import java.io.InputStream;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/23/2016.
 */
public class JacksonParsing {

    /*public List<NetworkEvent> deserializeEvents() throws IOException {
        List<NetworkEvent> events = new LinkedList<>();
        InputStream inputStream = getClass().getResourceAsStream("/events.json");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonEvents = objectMapper.readTree(inputStream);

        if (jsonEvents.isArray()) {
            for (JsonNode jsonEvent : jsonEvents) {
                NetworkEvent networkEvent = new NetworkEvent(
                        jsonEvent.path("deviceID").textValue(),
                        jsonEvent.path("networkID").textValue(),
                        OffsetDateTime.parse(jsonEvent.path("eventTime").textValue(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                );
                events.add(networkEvent);
            }
        }

        return events;
    }*/
}

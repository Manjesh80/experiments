package com.manjesh.rest.serialization;


//import com.manjesh.domain.model.NetworkEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
/*import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonArray;
import javax.json.JsonValue;*/


/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/23/2016.
 */
public class NetworkEventSerializerDemo {

    /*public List<NetworkEvent> deserializeEvents() throws IOException {
        List<NetworkEvent> events = new LinkedList<>();
        InputStream inputStream = getClass().getResourceAsStream("/events.json");
        Reader inputReader = new InputStreamReader(inputStream, "UTF-8");
        JsonReader jsonReader = Json.createReader(inputReader);
        JsonArray eventsJsonArray = jsonReader.readArray();

        for (JsonValue eventJson : eventsJsonArray) {
            if (eventJson.getValueType().equals(JsonValue.ValueType.OBJECT)) {
                JsonObject eventObject = (JsonObject) eventJson;
                NetworkEvent networkEvent = new NetworkEvent(
                        eventObject.getString("deviceID"),
                        eventObject.getString("networkID"),
                        OffsetDateTime.parse(eventObject.getString("eventTime"), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                );
                events.add(networkEvent);
            }
        }
        jsonReader.close();
        inputReader.close();
        inputStream.close();
        return events;
    }*/
}


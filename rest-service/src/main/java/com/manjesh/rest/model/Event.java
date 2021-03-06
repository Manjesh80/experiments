package com.manjesh.rest.model;

import java.time.OffsetDateTime;
import javax.ws.rs.FormParam;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 1/5/2017.
 */
public class Event {

    //@FormParam("deviceID")
    private String deviceID;
    //@FormParam("networkID")
    private String networkID;
    //@FormParam("eventTime")
    private OffsetDateTime eventTime;

    public Event() {
    }

    public Event(String deviceID, String networkID, OffsetDateTime eventTime) {
        this.deviceID = deviceID;
        this.networkID = networkID;
        this.eventTime = eventTime;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getNetworkID() {
        return networkID;
    }

    public void setNetworkID(String networkID) {
        this.networkID = networkID;
    }

    public OffsetDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(OffsetDateTime eventTime) {
        this.eventTime = eventTime;
    }
}

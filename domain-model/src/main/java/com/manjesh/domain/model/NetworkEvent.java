package com.manjesh.domain.model;

import java.time.OffsetDateTime;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/23/2016.
 */
public class NetworkEvent {

    private String deviceID;
    private String networkID;
    private OffsetDateTime eventTime;

    public NetworkEvent(){
    }

    public NetworkEvent(String deviceID, String networkID, OffsetDateTime eventTime) {
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

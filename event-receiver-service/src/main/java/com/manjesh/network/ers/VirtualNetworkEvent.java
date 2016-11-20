package com.manjesh.network.ers;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by aadhya on 11/19/2016.
 */


@XmlRootElement(name = "VirtualNetworkEvent")
public class VirtualNetworkEvent {

   /* public void setNetworkID(String networkID) {
        this.networkID = networkID;
    }
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }*/

    public String getNetworkID() {
        return networkID;
    }
    public int getDeviceID() {
        return deviceID;
    }

    public int deviceID;
    public String networkID;

    public VirtualNetworkEvent(int deviceID, String networkID) {
        this.deviceID = deviceID;
        this.networkID = networkID;
    }

    public VirtualNetworkEvent(){
    }

    @Override
    public int hashCode() {
        return this.deviceID;
    }

    @Path("/details")
    public String getDetails(){
        return "Device ID ==> " + Integer.toString(deviceID) + " ==> " + networkID;
    }

}

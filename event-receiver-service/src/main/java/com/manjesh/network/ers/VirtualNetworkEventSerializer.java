package com.manjesh.network.ers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by aadhya on 11/19/2016.
 */
@Provider
public class VirtualNetworkEventSerializer implements
        MessageBodyReader<VirtualNetworkEvent>, MessageBodyWriter<VirtualNetworkEvent> {

    @Override
    public VirtualNetworkEvent readFrom(Class<VirtualNetworkEvent> aClass, Type type, Annotation[] annotations,
                                        MediaType mediaType, MultivaluedMap<String, String> multivaluedMap,
                                        InputStream inputStream) throws IOException, WebApplicationException {
        try {
            System.out.println("  Ganesh ==> " + VirtualNetworkEvent.class.getPackage().getName());
            JAXBContext jaxbContext = JAXBContext.newInstance(VirtualNetworkEvent.class.getPackage().getClass());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            VirtualNetworkEvent virtualNetworkEvent = (VirtualNetworkEvent) unmarshaller.unmarshal(inputStream);
            return virtualNetworkEvent;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(VirtualNetworkEvent virtualNetworkEvent, Class<?> aClass, Type type, Annotation[] annotations,
                        MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(VirtualNetworkEvent virtualNetworkEvent, Class<?> aClass, Type type, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(VirtualNetworkEvent.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(virtualNetworkEvent, outputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

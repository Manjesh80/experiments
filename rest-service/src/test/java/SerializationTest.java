import com.manjesh.domain.model.NetworkEvent;
import com.manjesh.serialization.JacksonGenericDataBinding;
import com.manjesh.serialization.JacksonParsing;
import com.manjesh.serialization.NetworkEventSerializerDemo;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 12/23/2016.
 */
public class SerializationTest {
    @Test
    public void testNetworkEvents() throws Exception {

        NetworkEventSerializerDemo networkEventSerializerDemo = new NetworkEventSerializerDemo();
        List<NetworkEvent> events = networkEventSerializerDemo.deserializeEvents();

        Assert.assertEquals("Event count is correct", 2, events.size());
    }

    @Test
    public void testJacksonEvents() throws Exception {

        JacksonParsing jacksonParsing = new JacksonParsing();
        List<NetworkEvent> events = jacksonParsing.deserializeEvents();

        Assert.assertEquals("Event count is correct", 2, events.size());
    }

    @Test
    public void testJacksonGenericBinding() throws Exception {

        /*JacksonGenericDataBinding jacksonGenericDataBinding = new JacksonGenericDataBinding();
        List<NetworkEvent> events = jacksonGenericDataBinding.deserializeEvents();

        Assert.assertEquals("Event count is correct", 2, events.size());*/
    }

}

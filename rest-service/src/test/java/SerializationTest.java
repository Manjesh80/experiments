import com.manjesh.domain.model.NetworkEvent;
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
}

package service;

import com.manjesh.guicedemo.GuiceDemoFactory;
import com.manjesh.guicedemo.service.DataProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 11/17/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DataProviderServiceTest {

    @Test
    public void testRemoteDataService() throws Exception {
        DataProviderService dataProviderService = GuiceDemoFactory.create().createDtaProviderService();
        List<String> remoteData = dataProviderService.getData();
        assertThat(remoteData.size(), is(1));
        assertThat(remoteData.contains("Data from remote system"),is(Boolean.TRUE));
    }
}

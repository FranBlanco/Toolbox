package frequency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceListenerTest {

    @Before
    public void setup() {
        new ServiceListener("path", 3,"word", 10000);
    }

    @Test
    public void testIndicators() {

        ServiceListener.totalFilesWithFrequency = 0;

        ServiceListener.total = 0;

        ServiceListener.updateIndicators("filename1",3);

        Assert.assertNotNull(ServiceListener.files.get("filename1"));

        Assert.assertEquals("Unexpected value for frequency",3,ServiceListener.files.get("filename1").longValue());

        Assert.assertEquals("Unexpected value for total",3,0,ServiceListener.total);

        Assert.assertEquals("Unexpected value for totalFilesWIthFrequency",1,0,ServiceListener.total);
    }
}
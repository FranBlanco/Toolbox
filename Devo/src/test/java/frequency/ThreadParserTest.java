package frequency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@RunWith(PowerMockRunner.class)
//@PrepareForTest(ThreadParser.class)
public class ThreadParserTest {

    File mockedFile;

    ThreadParser threadParser;

    @Before
    public void init() {

        mockedFile =  Mockito.mock(File.class);

        Mockito.when(mockedFile.isDirectory()).thenReturn(true);

        threadParser = Mockito.spy(new ThreadParser("hello", mockedFile));

        MockitoAnnotations.initMocks(this);
        ServiceListener.total = 10;
        ServiceListener.totalFilesWithFrequency = 3;

        List<String> lines = new ArrayList<>();
        lines.add("word");
        lines.add("word");
        lines.add("hello");

        Supplier<Stream<String>> supplier = () -> lines.stream();

        Mockito.when(threadParser.getStreamSupplier(Mockito.anyString())).thenReturn(supplier);

    }

    @Test
    public void testCalculateDirectory() {

        threadParser.run();

        Assert.assertEquals("Unexpected value on calculator", 3, ServiceListener.totalFilesWithFrequency);
        Assert.assertEquals("Unexpected value on calculator", 10, 0, ServiceListener.total);
    }


    @Test
    public void testCalculateAlreadyParsed() {


        Mockito.when(mockedFile.isDirectory()).thenReturn(false);
        Mockito.when(mockedFile.getName()).thenReturn("filename");

        ServiceListener.files.put("filename", 10.0);

        threadParser.run();

        Assert.assertEquals("Unexpected value on calculator", 3, ServiceListener.totalFilesWithFrequency);
        Assert.assertEquals("Unexpected value on calculator", 10, 0, ServiceListener.total);
    }


    @Test
    public void testParseFile() throws Exception {

        Mockito.when(mockedFile.isDirectory()).thenReturn(false);
        Mockito.when(mockedFile.getName()).thenReturn("filename");
        Mockito.when(mockedFile.getAbsolutePath()).thenReturn("filename");

        threadParser.run();


        Assert.assertNotSame("Unexpected value on calculator", 3, ServiceListener.totalFilesWithFrequency);
        Assert.assertNotSame("Unexpected value on calculator", 10,ServiceListener.total);
    }

}
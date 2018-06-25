package frequency;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ThreadParserTest {


    @Test
    public void testCalculate(){

        ServiceListener.total = 10;
        ServiceListener.totalFilesWithFrequency = 3;

        ThreadParser threadParser = new ThreadParser("hello", new File("demo.txt"));
//        Assert.assertEquals("Unexpected value on calculator",0.9562446636327824,0.0,threadCalculator .calculate());
    }

}
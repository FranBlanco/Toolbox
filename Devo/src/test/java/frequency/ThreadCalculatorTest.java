package frequency;

import org.junit.Assert;
import org.junit.Test;


public class ThreadCalculatorTest {


    @Test
    public void testCalculate(){

        ServiceListener.total = 10;
        ServiceListener.totalFilesWithFrequency = 3;

        ThreadCalculator threadCalculator = new ThreadCalculator("demo.txt", 5);
        Assert.assertEquals("Unexpected value on calculator",0.9562446636327824,0.0,threadCalculator .calculate());
    }

}
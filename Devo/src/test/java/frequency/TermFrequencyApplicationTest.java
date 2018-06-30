package frequency;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TermFrequencyApplicationTest {

    //Integration test

    @Test
    public void main() throws Exception {
        String arguments = "-d / -n 3 -p 500 -t hola";
        new TermFrequencyApplication().main(arguments.split(" "));
        Assert.assertTrue("Execution finished without errors",true);
    }

}
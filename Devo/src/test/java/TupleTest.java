import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TupleTest {

    @Test
    public void testTuple(){

        Tuple input = new Tuple(1,2);
        Tuple expected = new Tuple(1,2);

        Assert.assertEquals("Unexpected vale for Tuple",expected,input);
        Assert.assertEquals("Unexpected vale for Element",1,input.getFirst());
        Assert.assertEquals("Unexpected vale for Element",2,input.getSecond());


    }

}
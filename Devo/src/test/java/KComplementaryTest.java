import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class KComplementaryTest {


    @Test
    public void calculateWithoutDuplicated(){

        int[] input ={1,2,3,4,5,6,7,8,9};

        Set<Tuple> expectedPairs = new HashSet<>();
        expectedPairs.add(new Tuple(1,4));
        expectedPairs.add(new Tuple(4,1));
        expectedPairs.add(new Tuple(3,2));
        expectedPairs.add(new Tuple(2,3));

        Assert.assertEquals("Unexpected number of values",expectedPairs,KComplementary.obtainKComplementaryPairs(input,5));
    }

    @Test
    public void calculateWithDuplicated(){

        int[] input ={0,0,5,5,1};

        Set<Tuple> expectedPairs = new HashSet<>();
        expectedPairs.add(new Tuple(5,0));
        expectedPairs.add(new Tuple(0,5));

        Assert.assertEquals("Unexpected number of values",expectedPairs,KComplementary.obtainKComplementaryPairs(input,5));
    }

    @Test
    public void calculateEmptyArray(){

        int[] input ={};

        Assert.assertEquals("Unexpected number of values",0,KComplementary.obtainKComplementaryPairs(input,5).size());
    }


    @Test
    public void calculateWithUniqueElement(){

        int[] input ={2};

        Assert.assertEquals("Unexpected number of values",0,KComplementary.obtainKComplementaryPairs(input,4).size());
    }
}
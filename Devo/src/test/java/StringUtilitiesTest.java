import org.junit.Assert;
import org.junit.Test;


public class StringUtilitiesTest {


    @Test
    public void emptyString(){
        Assert.assertTrue("Ünexpected result for an empty string: ",StringUtilities.isPalindrome(""));
    }

    @Test
    public void oneCharacterString(){
        Assert.assertTrue("Ünexpected result for string: 'a'",StringUtilities.isPalindrome("a"));
    }

    @Test
    public void palindromeString(){
        Assert.assertTrue("Unexpected result for string 'abcba'",StringUtilities.isPalindrome("abcba"));
    }

    @Test
    public void notAPalindromeString(){
        Assert.assertFalse("Unexpected result for string 'abcbA'",StringUtilities.isPalindrome("abcbA"));
    }

}
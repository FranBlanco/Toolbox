
public class StringUtilities {


    /**
     * Check if the input String is a palindrome
     * @param input
     * @return a boolean true if is palindrome otherwise false
     */
    public static boolean isPalindrome(final String input){

        for(int i=0; i < input.length()/2; i++){

            if(input.charAt(i) != input.charAt((input.length()-1-i))){

                return false;
            }
        }

        return true;
    }
}

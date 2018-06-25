import java.util.*;

public class KComplementary {


    /**
     * Obtain All complementary pairs given an array and K.
     * @param input
     * @param k
     * @return All Pairs elements without duplicated values
     */
    public static Set<Tuple> obtainKComplementaryPairs(final int[] input, final int k){

        Map<Integer,Integer> frequencies = calculateFrequencies(input);

        Set<Tuple> pairs = new HashSet<>();

        for(int i = 0; i < input.length; i++){

            int firstElement = input[i];

            int secondElement = k-firstElement;

            Optional<Integer>  frequencyFirstElement = Optional.ofNullable(frequencies.get(input[i]));

            Optional<Integer> frequencySecondElement = Optional.ofNullable(frequencies.get(secondElement));

            if(frequencyFirstElement.isPresent() && frequencySecondElement.isPresent() && (secondElement != firstElement || frequencyFirstElement.get() > 1 )){

                pairs.add(new Tuple(firstElement,secondElement)) ;

            }

        }

        return pairs;
    }

    private static Map calculateFrequencies(final int[] input) {

        final Map<Integer, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < input.length; i++) {

            if (frequencies.get(input[i]) == null) {

                frequencies.put(input[i], 1);

            } else {
                frequencies.put(input[i], frequencies.get(input[i]) + 1);

            }

        }
        return frequencies;
    }
}

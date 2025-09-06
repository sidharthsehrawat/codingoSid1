package Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A utility class that provides methods for processing and analyzing integer data.
 * This class is designed for tasks such as filtering and calculating the frequency of integers
 * based on specified conditions.
 * <p>
 * This class includes static methods that can be accessed without creating an instance.
 * <p>
 * Requirements and notes:
 * - You can use Google if you get stuck
 * - You can ask any AI for help if you get stuck, but don't ask to generate the code
 * - You can ask questions if you get stuck
 * - You can ask questions if you get stuck
 * - Use your IDE to write the code
 * - Use a debugger if needed
 * - Use Stream API (preferable)
 * - User method references where possible
 * - Do not modify the original input
 */
class SuperUtilClass {

    /**
     * Calculates the frequency of integers in the given input string that match the allowed set
     * and meet the minimum frequency requirement.
     *
     * @param intput       the input string containing integers separated by commas
     * @param allowed      a set of integers that are allowed for frequency calculation
     * @param minFrequency the minimum frequency threshold for an integer to be included in the result
     * @return a map where the keys are the integers that are both in the allowed set and meet the frequency threshold,
     * and the values are their respective frequencies
     */
    public static Map<Integer, Long> getIntFrequency(String intput, Set<Integer> allowed, long minFrequency) {
        /* TODO: Implement this method */

       return  Arrays.stream(intput.split(",")).map(String::trim)
               .map(SuperUtilClass::StringToInt)
               .filter(Objects::nonNull)
               .filter(allowed::contains)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
               .entrySet().stream()
               .filter(e -> e.getValue() >= minFrequency)
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Integer StringToInt(String e) {
        try {
         return Integer.parseInt(e);
        }catch (NumberFormatException ex){
            return null;
        }
    }


    public static void main(String[] args) {
        /* Given */
        String intput = "99, 12, oops,12, ,0,12 , ,0,0,0,1";

        Set<Integer> allowed = new HashSet<>();
        allowed.add(12);
        allowed.add(99);
        int minFrequency = 2;

        /* When */
        Map<Integer, Long> result = SuperUtilClass.getIntFrequency(intput, allowed, minFrequency);

        /* Then the expected map is {99=2, 12=3}. Order doesn't matter */
        System.out.println(result);
        verify(result);
    }

    private static void verify(Map<Integer, Long> result) {
        if (result.size() != 2) {
            throw new RuntimeException("Oops. Expected 1 result, got " + result.size());
        }
        if (!result.containsKey(12)) {
            throw new RuntimeException("Oops. Expected 12 to be present in the result");
        }
        if (!result.containsKey(99)) {
            throw new RuntimeException("Oops. Expected 99 to be present in the result");
        }
        if (result.get(12) != 3) {
            throw new RuntimeException("Oops. Expected 3 occurrences of 12 in the result");
        }
        if (result.get(99) != 2) {
            throw new RuntimeException("Oops. Expected 2 occurrences of 12 in the result");
        }
    }

    private SuperUtilClass() {
    }
}

package folder.LC_mock;

import java.util.HashSet;
import java.util.Set;

public class Reverse {
    public static void main(String[] args) {

        // Q-1 Given a signed 32-bit integer x, return x with its digits reversed.
        // If reversing x causes the value to go outside the signed 32-bit integer
        // range [-231, 231 - 1], then return 0.

        Set<Integer> set = new HashSet<>();
        int x = 10900;
        int rem = x % 10;
        int rema = x / 10;

        String s = Integer.toString(x);
        System.out.println();
    }
}

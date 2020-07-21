import java.io.*;
import java.util.*;

class PermutationOfSpaces {
    public static void permutationOfSpaces(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        String output1 = output + Character.toString(input.charAt(0));
        String output2 = output + "_" + Character.toString(input.charAt(0));
        input = input.substring(1);
        permutationOfSpaces(input, output1);
        permutationOfSpaces(input, output2);
    }

    public static void main(String[] args) {
        /**
         * Output should be abc, ab_c, a_bc, a_b_c
         */
        String str = "abc";
        permutationOfSpaces(str.substring(1), Character.toString(str.charAt(0)));
    }
}
import java.io.*;
import java.util.*;

class AllSubsequence {
    public static void allSubsequence(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        String output1 = output;
        String output2 = output + Character.toString(input.charAt(0));
        input = input.substring(1); // remove first character from input
        allSubsequence(input, output1);
        allSubsequence(input, output2);
    }

    public static void main(String[] args) {
        String str = "abc";
        allSubsequence(str, "");
    }
}
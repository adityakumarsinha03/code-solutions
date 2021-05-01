import java.io.*;
import java.util.*;

class LetterCasePermutation {
    public static void letterCasePermutationUtil(String input, String output, List<String> ans) {
        if (input.length() == 0) {
            ans.add(output);
            return;
        }
        if (((int) input.charAt(0) >= 65 && (int) input.charAt(0) <= 90)
                || ((int) input.charAt(0) >= 97 && (int) input.charAt(0) <= 122)) {
            String output1 = output + Character.toString(input.charAt(0)).toLowerCase();
            String output2 = output + Character.toString(input.charAt(0)).toUpperCase();
            input = input.substring(1);
            letterCasePermutationUtil(input, output1, ans);
            letterCasePermutationUtil(input, output2, ans);
        } else {
            output = output + Character.toString(input.charAt(0));
            input = input.substring(1);
            letterCasePermutationUtil(input, output, ans);
        }
    }

    public static List<String> letterCasePermutation(String S) {
        String output = "";
        List<String> ans = new ArrayList<>();
        letterCasePermutationUtil(S, output, ans);
        return ans;
    }

    public static void main(String[] args) {
        String str = "a1Bc2";
        letterCasePermutation(str);
    }
}
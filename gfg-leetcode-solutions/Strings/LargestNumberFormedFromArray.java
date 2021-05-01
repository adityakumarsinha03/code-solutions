// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}

class Solution {
    String printLargest(String[] arr) {
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String x, String y){
                return (y+x).compareTo(x+y);
            }
        });
        
        String ans = "";
        for(int i = 0; i<arr.length; i++){
            ans += arr[i];
        }
        return ans;
    }
}
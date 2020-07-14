import java.io.*;
import java.util.*;

class SortArray {
    public static void insert(List<Integer> ar, int temp) {
        if (ar.size() == 0 || ar.get(ar.size() - 1) <= temp) {
            ar.add(temp);
            return;
        }
        int lastEle = ar.get(ar.size() - 1);
        ar.remove(ar.size() - 1);
        insert(ar, temp);
        ar.add(lastEle);
    }

    public static void sort(List<Integer> ar) {
        if (ar.size() == 1)
            return;

        int temp = ar.get(ar.size() - 1);
        ar.remove(ar.size() - 1);
        sort(ar);
        insert(ar, temp);
    }

    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>();
        ar.add(3);
        ar.add(2);
        ar.add(5);
        ar.add(0);
        sort(ar);
        System.out.println(ar);
    }
}
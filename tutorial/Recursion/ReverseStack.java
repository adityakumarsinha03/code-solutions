import java.io.*;
import java.util.*;

class ReverseStack {
    public static void insert(Stack<Integer> st, int temp) {
        if (st.size() == 0) {
            st.push(temp);
            return;
        }
        int lastEle = st.pop().intValue();
        insert(st, temp);
        st.push(lastEle);
    }

    public static void reverseStack(Stack<Integer> st) {
        if (st.size() == 1)
            return;
        int temp = st.pop().intValue();
        reverseStack(st);
        insert(st, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(2);
        st.push(5);
        st.push(0);
        reverseStack(st);
        System.out.println(st);
    }
}
import java.io.*;
import java.util.*;

class DeleteMiddleElementInStack {
    public static void deleteMiddleElement(Stack<Integer> st, int k) {
        if (k == 1) {
            st.pop();
            return;
        }
        int temp = st.pop().intValue();
        deleteMiddleElement(st, k - 1);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(2);
        st.push(5);
        st.push(0);
        deleteMiddleElement(st, (st.size() / 2) + 1);
        System.out.println(st);
    }
}
// https://practice.geeksforgeeks.org/problems/josephus-problem/1

public class JosephusProblem {
    public int josephus(int n, int k) {
        if (n == 1)
            return 1;
        /**
         * In this case, we start from position 1. So, we have % n + 1, so that when %
         * results into 0, we consider it as 1st position. Also, we need to skip k-1
         * people, so func() + (k-1)
         */
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }
}
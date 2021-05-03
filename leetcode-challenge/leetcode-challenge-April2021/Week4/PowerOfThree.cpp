// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3722/

class isPowerOfThree {
public:
    int log_a_to_base_b(int a, int b) {
        return (a > b - 1)
			? 1 + log_a_to_base_b(a / b, b)
			: 0;
    }
    bool isPowerOfThree(int n) {
        if(n<=0)
            return false;
        
        int p = log_a_to_base_b(n, 3);
        if(pow(3, p) == n)
            return true;
        return false;
    }
};
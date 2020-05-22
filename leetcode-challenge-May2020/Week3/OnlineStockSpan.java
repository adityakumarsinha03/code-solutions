// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/

class StockSpanner {

    Stack<Integer> stValue = new Stack<>();
    Stack<Integer> stCount = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int x = 1;
        int popC = 0;
        while (!stValue.empty() && stValue.peek() <= price) {
            stValue.pop();
            popC++;
        }
        stValue.push(price);
        while (popC > 0) {
            x += stCount.peek();
            stCount.pop();
            popC--;
        }
        stCount.push(x);
        return stCount.peek();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */
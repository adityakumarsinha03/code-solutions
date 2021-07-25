// https://leetcode.com/problems/seat-reservation-manager/

class SeatManager {

    PriorityQueue<Integer> pq;
    Map<Integer, Integer> mp;
    public SeatManager(int n) {
        pq = new PriorityQueue<>(n, new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });
        
        for(int i = 1; i<=n; i++){
            pq.add(i);
        }
        
        mp = new HashMap<>();
    }
    
    public int reserve() {
        int seat = -1;
        if(!pq.isEmpty()){
            seat = pq.peek();
            pq.remove();
            mp.put(seat, 1);
        }
        return seat;
    }
    
    public void unreserve(int seatNumber) {
        mp.put(seatNumber, 0);
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
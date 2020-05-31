// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/

class Solution {
    public Double calcDistance(int x, int y){
        Double dist = Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
        return dist;
    }
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        HashMap<Double, List<Integer> > mp = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            Double dist = calcDistance(points[i][0], points[i][1]);
            mp.compute(dist, (key, val) -> (val==null) ? new ArrayList<>() : val).add(i);
            pq.add(dist);
        }
        
        int ans[][] = new int[k][2];
        int i = 0;
        while(i<k && !pq.isEmpty()){
            List<Integer> temp = mp.get(pq.peek());
            pq.poll();
            for(int j = 0; j<temp.size(); j++){
                ans[i] = points[temp.get(j)];
                i++;
            }
        }
        return ans;
    }
}
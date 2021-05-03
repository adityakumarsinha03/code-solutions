// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3729/

class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        
        Arrays.sort(courses, new Comparator<>(){
            @Override
            public int compare(int a[], int b[]){
                if(a[1] == b[1])
                    return a[0]-b[0];
                else
                    return a[1]-b[1];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int totTime = 0;
        
        for(int i = 0; i<n; i++){
            if(courses[i][0]+totTime <= courses[i][1]){
                pq.add(courses[i][0]);
                totTime += courses[i][0];
            }
            else{
                if(!pq.isEmpty()){
                    int top = pq.peek();
                    if(courses[i][0] < top){
                        pq.remove();
                        pq.add(courses[i][0]);
                        totTime += courses[i][0]-top;
                    }
                }
            }
        }
        return pq.size();
    }
}
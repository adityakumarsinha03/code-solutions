// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3950/

class Job{
    int start;
    int finish;
    int money;
    
    public Job(int start, int finish, int money){
        this.start = start;
        this.finish = finish;
        this.money = money;
    }
}
class Solution {
    public int leftJob(List<Job> jobs, int i){
        for(int j = i-1; j>=0; j--){
            if(jobs.get(j).finish <= jobs.get(i).start)
                return j;
        }
        return -1;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = profit.length;
        
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i<n; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        jobs.sort(
            (Job job1, Job job2) -> Integer.compare(job1.finish, job2.finish)
        );
               
        int[] res = new int[n];
        res[0] = jobs.get(0).money;
        
        for(int i = 1; i<n; i++){
            int incl = jobs.get(i).money;
            int left = leftJob(jobs, i);
            if(left != -1)
                incl += res[left];
            
            res[i] = Math.max(res[i-1], incl);    
        }
        
        return res[n-1];
    }
}
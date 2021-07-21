// https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        
        List<Pair<Integer, Integer> > intervalsL = new ArrayList<>();
        for(int i = 0; i<n; i++){
            intervalsL.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        
        Collections.sort(intervalsL, new Comparator<Pair<Integer, Integer> >(){
            @Override
            public int compare(Pair<Integer, Integer>  p1, Pair<Integer, Integer>  p2){
                if(p1.getKey()-p2.getKey() == 0)
                    return p1.getValue()-p2.getValue();
                return p1.getKey()-p2.getKey();
            }
        });
        
        // System.out.println(intervalsL);
        
        List<Pair<Integer, Integer> > ans = new ArrayList<>();
        
        int start = intervalsL.get(0).getKey();
        int end = intervalsL.get(0).getValue();
        
        for(int i = 1; i<n; i++){
            int st = intervalsL.get(i).getKey();
            if(st <= end){
                end = Math.max(end, intervalsL.get(i).getValue());
            } else{
                ans.add(new Pair(start, end));
                start = intervalsL.get(i).getKey();
                end = intervalsL.get(i).getValue();
            }
        }
        ans.add(new Pair(start, end));
        
        int[][] retans = new int[ans.size()][2];
        for(int i = 0; i<ans.size(); i++){
            retans[i][0] = ans.get(i).getKey();
            retans[i][1] = ans.get(i).getValue();
        }
        return retans;
    }
}
// https://practice.geeksforgeeks.org/problems/box-stacking/1

class Box{
    int l;
    int w;
    int h;
    Box(int len, int wid, int hei){
        l = len;
        w = wid;
        h = hei;
    }
    public static Comparator<Box> compareBase = new Comparator<Box>() {
    	public int compare(Box b1, Box b2) {
    	    return (((b2.l) * (b2.w))-((b1.l) * (b1.w)));
       }
    };
}

class Geeks {
    public static int maxHeight(int height[], int width[], int length[], int n){
       
       ArrayList<Box> boxes = new ArrayList<Box>();
       for(int i = 0; i<n; i++){
            Box b1 = new Box(Math.max(width[i],height[i]), Math.min(width[i],height[i]), length[i]);
            boxes.add(b1);
            Box b2 = new Box(Math.max(length[i],height[i]), Math.min(length[i],height[i]), width[i]);
            boxes.add(b2);
            Box b3 = new Box(Math.max(length[i],width[i]), Math.min(length[i],width[i]), height[i]);
            boxes.add(b3);
        }
        Collections.sort(boxes, Box.compareBase);
        
        int dp[] = new int[3*n];
        for(int i = 0; i<3*n; i++){
            dp[i] = boxes.get(i).h;
        }
        
        for(int i = 1; i<3*n; i++){
            for(int j = 0; j<i; j++){
                if(boxes.get(i).l < boxes.get(j).l
                    && boxes.get(i).w < boxes.get(j).w
                    && dp[i] < dp[j]+boxes.get(i).h){
                    dp[i] = dp[j]+boxes.get(i).h;
                }
            }
        }
        int ans = -1;
        for(int i = 0; i<3*n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
   }
}
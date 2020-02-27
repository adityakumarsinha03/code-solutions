class Solution {
    public int equiPoint(int ar[], long sum){
        
        if(ar.length < 1){
            return -1;
        }
        if(ar.length<2){
            return 0;
        }
        long sumBef = 0;
        for(int i = 0; i<ar.length; i++){
            sumBef += ar[i];
            if(sumBef-ar[i] == sum-sumBef){
                return i;
            }
        }
        return -1;
    }
    public int pivotIndex(int[] ar) {
        long sum = 0;
        for(int i = 0; i<ar.length; i++){
          sum += ar[i];
        }
        return (equiPoint(ar, sum));
    }
}
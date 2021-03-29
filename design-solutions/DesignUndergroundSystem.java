class UndergroundSystem {

    Map<Integer, Pair<String, Integer> > mu;
    Map<Pair<String, String>, Pair<Long, Long> > mag;
    
    public UndergroundSystem() {
        mu = new HashMap<>();
        mag = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        mu.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(mu.containsKey(id)){
            Pair<String, Integer> temp = mu.get(id);
            String startStation = temp.getKey();
            
            int time = Math.abs(t - temp.getValue());
            
            Pair<String, String> pp = new Pair(startStation, stationName);
            long totTime = 0, totNum = 0;
            if(mag.containsKey(pp)){
                totTime = mag.get(pp).getKey();
                totNum = mag.get(pp).getValue();
            }
            mag.put(pp, new Pair(totTime+time, totNum+1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String> pp = new Pair(startStation, endStation);
        double value = 0;
        if(mag.containsKey(pp)){
            double totTime = mag.get(pp).getKey();
            double totNum = mag.get(pp).getValue();
            value = totTime/totNum;
        }
        return (double)Math.round(value * 100000d) / 100000d;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
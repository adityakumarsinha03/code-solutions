class AuthenticationManager {

    Map<String, Integer> mp;
    int timeToLive;
    
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        mp = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        mp.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(mp.containsKey(tokenId) && mp.get(tokenId)+timeToLive > currentTime){
            mp.put(tokenId, currentTime);
        }
        return;
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int[] unexpiredToken = new int[]{0};
        mp.forEach((k, v) -> {
                  if(v+timeToLive > currentTime){
                      unexpiredToken[0]++;
                  }});
        return unexpiredToken[0];
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
// https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3728/

class WordFilter {

    Map<String, Integer> mp;
    public WordFilter(String[] words) {
        
        mp = new HashMap<>();
        for(int i = 0; i<words.length; i++){
            List<String> prefix = new ArrayList<>();
            List<String> suffix = new ArrayList<>();
            
            for(int j = 0; j<=words[i].length(); j++){
                prefix.add(words[i].substring(0, j));
                suffix.add(words[i].substring(j));
            }
            
            for(int p = 0; p<prefix.size(); p++){
                for(int q = 0; q<suffix.size(); q++){
                    String temp = prefix.get(p) + "#" + suffix.get(q);
                    if(!mp.containsKey(temp))
                        mp.put(temp, i);
                    else
                        mp.put(temp, Math.max(i, mp.get(temp)));
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String search = prefix + "#" + suffix;
        if(mp.containsKey(search))
            return mp.get(search);
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
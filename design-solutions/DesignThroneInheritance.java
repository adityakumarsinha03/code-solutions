// https://leetcode.com/problems/throne-inheritance/

class ThroneInheritance {

    Map<String, Integer> mp;
    Map<String, List<String> > chmap;
    
    String king;
    public ThroneInheritance(String kingName) {
        mp = new HashMap<>();
        chmap = new HashMap<>();
        
        mp.put(kingName, 1);
        this.king = kingName;
    }
    
    public void birth(String parentName, String childName) {
        mp.put(childName, 1);
        
        List<String> temp = new ArrayList<>();
        if(chmap.containsKey(parentName))
            temp = chmap.get(parentName);
        temp.add(childName);
        chmap.put(parentName, temp);
    }
    
    public void death(String name) {
        mp.put(name, 0);
    }
    
    public void getInheritanceOrderUtil(List<String> inheritOrder, String kingName) {
        if(mp.containsKey(kingName) && mp.get(kingName)!=0)
            inheritOrder.add(kingName);
        
        if(chmap.containsKey(kingName)){
            List<String> children = chmap.get(kingName);
            for(String ch : children){
                getInheritanceOrderUtil(inheritOrder, ch);
            }
        }
    }
    public List<String> getInheritanceOrder() {
        List<String> inheritOrder = new ArrayList<>();
        getInheritanceOrderUtil(inheritOrder, this.king);
        return inheritOrder;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
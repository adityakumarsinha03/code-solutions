// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/

class TrieNode{
    TrieNode[] children = new TrieNode[26];
        
    boolean endOfWord;
    TrieNode(){
        endOfWord = false;
        for(int i = 0; i<26; i++)
            children[i]= null;
    }
}

class Trie {

    /** Initialize your data structure here. */
    private static TrieNode root;
    
    public Trie() {
        root = new TrieNode();   
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        int ind;
        
        TrieNode p = root;
        for(int i = 0; i<n; i++){
            ind = word.charAt(i) - 'a';
            if(p.children[ind] == null)
                p.children[ind] = new TrieNode();
            p = p.children[ind];
        }
        p.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n = word.length();
        int ind;
        
        TrieNode p = root;
        for(int i = 0; i<n; i++){
            ind = word.charAt(i) - 'a';
            if(p.children[ind] == null)
                return false;
            else
                p = p.children[ind];
        }
        if(p != null && p.endOfWord == true)
            return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        int ind;
        
        TrieNode p = root;
        for(int i = 0; i<n; i++){
            ind = prefix.charAt(i) - 'a';
            if(p.children[ind] == null)
                return false;
            else
                p = p.children[ind];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
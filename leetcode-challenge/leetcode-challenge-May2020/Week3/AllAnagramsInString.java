// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        int parr[] = new int[26];

        for (int i = 0; i < 26; i++) {
            parr[i] = 0;
        }
        for (int i = 0; i < p.length(); i++) {
            int x = (int) p.charAt(i);
            parr[x - 97]++;
        }

        int flag = 0;
        for (int i = 0; i < s.length() && s.length() - i >= p.length(); i++) {
            flag = 0;
            String temp = s.substring(i, i + p.length());
            int sarr[] = new int[26];
            for (int j = 0; j < 26; j++) {
                sarr[j] = parr[j];
            }
            for (int j = 0; j < temp.length(); j++) {
                int x = (int) temp.charAt(j);
                sarr[x - 97]--;
            }
            for (int j = 0; j < 26; j++) {
                if (sarr[j] != 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                ans.add(i);
        }
        return ans;
    }
}
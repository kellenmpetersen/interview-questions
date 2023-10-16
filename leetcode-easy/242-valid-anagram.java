//  LeetCode - 242. Valid Anagram
//  https://leetcode.com/problems/valid-anagram
//  time to solve: 7:17 (Oct 16 2023)
//  optimal solution consulted: https://leetcode.com/problems/valid-anagram/solutions/3687854/3-method-s-c-java-python-beginner-friendly/
//      (I like my solution the best, even though it is verbose
//      it accounts for edge cases better and only consists of two loops, not three)
//  concept: NeetCode (2/9) Arrays & Hashing

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int n = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),++n);
        }
        for(int j = 0; j < t.length(); j++){
            int n = map.getOrDefault(t.charAt(j),-1);
            if(n <= 0){
                return false;
            }
            map.put(t.charAt(j),--n);
        }
        return true;
    }
}
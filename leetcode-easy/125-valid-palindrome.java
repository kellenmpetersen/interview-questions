//  LeetCode - 125. Valid Palindrome
//  https://leetcode.com/problems/valid-palindrome
//  time to solve: 16:53 (Oct 19 2023)
//  concept: NeetCode (1/5) Two Pointers
//  TODO:   cleaning up the string so it could be analyzed was the most painful part of this problem;
//          looking more into converting string to lowercase only characters might be worthwhile.

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length()-1;
        while(start != end && end > -1 && start < s.length()){
            System.out.println("success for:"+start+","+end);
            if(Character.isLetterOrDigit(s.charAt(start)) && Character.isLetterOrDigit(s.charAt(end))){
                if(s.charAt(start) != s.charAt(end)){
                    System.out.println("failed at:"+start+","+end);
                    return false;
                }
                start++;
                end--;
            } else if(!Character.isLetterOrDigit(s.charAt(start)) && Character.isLetterOrDigit(s.charAt(end))){
                start++;
            } else if(Character.isLetterOrDigit(s.charAt(start)) && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
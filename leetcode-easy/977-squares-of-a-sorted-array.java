//  LeetCode - 977. Squares of a Sorted Array
//  https://leetcode.com/problems/squares-of-a-sorted-array
//  time to solve: 11:11 (Sep 14 2023)
//  TODO:   edge cases with these two pointers . . . was one off again on while loop boundary
//          loop invarients?

class Solution {
    public int[] sortedSquares(int[] nums) {
        //  brainstorming
        //      two-pointers
        //      time: 40s
        int start = 0;
        int end = nums.length - 1;
        int[] squares = new int[nums.length];
        int tracker = nums.length - 1;
        while(start != end + 1){
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                squares[tracker] = (int)Math.pow(nums[start],2);
                tracker--;
                start++;
            } else {
                squares[tracker] = (int)Math.pow(nums[end],2);
                tracker--;
                end--;
            }
        }
        return squares;
    }
}
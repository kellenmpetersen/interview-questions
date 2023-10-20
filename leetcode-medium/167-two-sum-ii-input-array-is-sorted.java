//  LeetCode - 167. Two Sum II - Input Array Is Sorted
//  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//  time to solve: 5:22 (Oct 19 2023)
//  concept: NeetCode (2/5) Two Pointers
//  TODO:   read the problem and examples carefully. I didn't return
//          the correct indices initally.

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int num1 = 0, num2 = numbers.length-1;
        while(numbers[num1] + numbers[num2] != target){
            if(target > numbers[num1] + numbers[num2]){
                num1++;
            } else if(target < numbers[num1] + numbers[num2]){
                num2--;
            }
        }
        return new int[]{++num1,++num2};
    }
}
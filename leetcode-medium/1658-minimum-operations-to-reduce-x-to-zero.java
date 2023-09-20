//  LeetCode - 1658. Minimum Operations to Reduce X to Zero
//  https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero
//  time problem solving: 36:48 (Sep 20 2023)
//  solution consulted:
//  https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/solutions/4066422/96-51-sliding-window/
//  TODO:   learn sliding window pattern
//          consider edge cases

class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x, n = nums.length;
        for(int num : nums){
            target += num;
        }
        if(target == 0){
            return n;
        }
        int maxLength = 0, currentSum = 0, left = 0;
        
        for(int right = 0; right < n; ++right){
            currentSum += nums[right];
            while(left <= right && currentSum > target){
                currentSum -= nums[left];
                left++;
            }
            if(currentSum == target){
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength != 0 ? n - maxLength : -1;
    }
}

class IncorrectSolution {
    public int minOperations(int[] nums, int x) {
        /*
        *   brainstorm:
        *       need to keep track of numbers on either side of nums[] to see how subtracting it would
        *       result in a val of zero. probably a dynamic programming problem since the in-progress answer would
        *       be stored to increase efficency? store the indices used to get zero
        *       minimum number of operations would be reached by taking the maximum number that could
        *       be subtracted from x from either left or right and be greater than or equal to zero.
        *       int left = 0, int right = nums.length-1;
        *       while(left != right){
        *           if(x == 0){
        *               return count;
        *           }
        *           if(nums[left] > nums[right]){
        *               if(x - nums[left] >= 0)
        *               else if(x - nums[right] >= 0)
        *           } else if nums[right] > nums left
        *           
        *       }
        */
        int ops = 0;
        int left = 0, right = nums.length - 1;
        while(x > 0){
            if(nums[left] > nums[right]){
                if(x - nums[left] >= 0){
                    x -= nums[left];
                    ops++;
                    left++;
                } else if(x - nums[right] >= 0) {
                    x -= nums[right];
                    ops++;
                    right--;
                } else {
                    return -1;
                }
            } else if(nums[right] >= nums[left]) {
                if(x - nums[right] >= 0){
                    x -= nums[right];
                    ops++;
                    right--;
                } else if(x - nums[left] >= 0) {
                    x -= nums[left];
                    ops++;
                    left++;
                } else {
                    return -1;
                }
            }
            if(left > right){
                return -1;
            }
        }
        if(x == 0){
            return ops;
        } else {
            return -1;
        }
    }
}
//  LeetCode - 448. Find All Numbers Disappeared in an Array
//  https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
//  time to solve: 9:27 (Sep 14 2023)
//  (solved this problem on a phone call so excuse the generic variable names)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 1; i <= nums.length; i++){
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
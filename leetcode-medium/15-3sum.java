//  LeetCode - 15. 3Sum
//  https://leetcode.com/problems/3sum
//  time spent problem-solving: ~45:00 (Oct 19 2023)
//  optimal solution consulted: https://leetcode.com/problems/3sum/solutions/3736346/java-easiest-solution-ever/
//  concept: NeetCode (3/5) Two Pointers
//  TODO:   I got pretty stumped on this one, even though I read the hint after 30:00
//          that said to break it down into subproblems related to two-sum . . .
//          My greatest struggle was covering all the cases by maintaining the invarient that i != j != k
//          for any answer.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> threeSum = new ArrayList<>();

        for(int k = 0; k < nums.length - 2; k++){
            if(k > 0 && nums[k] == nums[k-1]){
                continue;
            }

            int i = k + 1;
            int j = nums.length - 1;

            while(i < j){
                if(nums[i] + nums[j] + nums[k] == 0){
                    // add values
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(nums[i]);
                    currentList.add(nums[j]);
                    currentList.add(nums[k]);
                    threeSum.add(currentList);

                    // skip duplicates
                    while(i < j && nums[i] == nums[i+1]){
                        i++;
                    }
                    while(i < j && nums[j] == nums[j-1]){
                        j--;
                    }

                    // move pointers
                    i++;
                    j--;

                } else if(nums[i] + nums[j] + nums[k] < 0){
                    i++;
                } else{
                    j--;
                }
            }
        }
        return threeSum;
    }
}
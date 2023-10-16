//  LeetCode - 1. Two Sum
//  https://leetcode.com/problems/two-sum/
//  time to solve: 1:40 (Oct 16 2023)
//  optimal solution consulted: https://leetcode.com/problems/two-sum/solutions/2671539/java-100-runtime-easy-to-understand/
//  concept: NeetCode (3/9) Arrays & Hashing

class OptimalSolution{
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

class MySolution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j && nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
//  LeetCode - 217. Contains Duplicate
//  https://leetcode.com/problems/contains-duplicate
//  time to solve: 11:20 (Oct 16 2023)
//  optimal solution consulted: https://leetcode.com/problems/contains-duplicate/solutions/3163705/java-best-solution-3-ways/
//  concept: NeetCode (1/9) Arrays & Hashing

class OptimalSolution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],0);
        }
        return false;
    }
}

class MySolution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int n = map.getOrDefault(nums[i],0);
            n++;
            map.put(nums[i],n);
        }
        for(Integer n : map.keySet()){
            int val = map.get(n);
            if(val > 1){
                return true;
            }
        }
        return false;
    }
}
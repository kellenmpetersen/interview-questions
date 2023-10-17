//  LeetCode - 238. Product of Array Except Self
//  https://leetcode.com/problems/product-of-array-except-self
//  time to problem solve: ~50:00 (Oct 17 2023)
//  optimal solution consulted: https://leetcode.com/problems/product-of-array-except-self/solutions/4069888/simple-and-easy-1-min-explanation-in-python-and-java/
//  concept: NeetCode (6/9) Arrays & Hashing
//  TODO: study prefix/postfix patterns

class OptimalSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] toReturn = new int[nums.length];
        int k = 1;
        // prefix
        for(int i = 0; i < nums.length; i++){
            toReturn[i] = k;
            k *= nums[i];
        }
        k = 1;
        // postfix
        for(int j = nums.length - 1; j >= 0; j--){
            toReturn[j] *= k;
            k *= nums[j];
        }
        return toReturn;
    }
}
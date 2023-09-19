//  LeetCode - 287. Find the Duplicate Number
//  https://leetcode.com/problems/find-the-duplicate-number
//  time to solve: 2:16 (Sep 19 2023)
//  solution consulted:
//  https://leetcode.com/problems/find-the-duplicate-number/solutions/4062141/97-77-6-approaches-set-count-binary-search-fast-slow-mark-sort/
//  TODO:   read the problem requirements carefully (my code passed tests but did not meet problem's requirements)
//          think about applying various algorithmic approaches to different data structures (I've practiced 2-pointers with LinkedLists)

class BestSolution {
    //  method used: Two Pointers Approach
    //  space complexity: O(1), no extra space required
    //  time complexity: O(n), n = array length
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

class MySolution {
    //  method used: HashSet
    //  time to solve 2:16
    public int findDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(unique.contains(nums[i])){
                return nums[i];
            }
            unique.add(nums[i]);
        }
        return -1;
    }
}
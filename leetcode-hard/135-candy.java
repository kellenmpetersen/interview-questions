//  LeetCode - 
//  https://leetcode.com/problems/candy
//  time problem solving: ~19:00 (Sep 13 2023)
//  solution consulted:
//  https://leetcode.com/problems/candy/solutions/4037646/99-20-greedy-two-one-pass/
//  TODO:   learn more about greedy algorithms
//          edgecases, edgecases, edgecases
//          try to do two passes/loops first before optimizing to one pass/loop

class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0){
            return 0;
        }
        int candyCount = 1;
        int up = 0, down = 0, peak = 0;
        for(int i = 0; i < ratings.length - 1; i++){
            int prev = ratings[i];
            int curr = ratings[i+1];
            if(prev < curr){
                up++;
                down = 0;
                peak = up;
                candyCount += 1 + up;
            } else if (prev == curr){
                up = 0;
                down = 0;
                peak = 0;
                candyCount += 1;
            } else {
                up = 0;
                down ++;
                candyCount += 1 + down;
                if (peak >= down){
                    candyCount--;
                }
            }
        }
        return candyCount;
    }
}

class IncorrectSolution {
    public int candy(int[] ratings) {
        /*
        *   Brainstorming: (Intuition)
        *   this is likely a loop with the candy distribution logic controlled by if statements   
        *   considering each child must have one candy, a pass can be made through giving each child a candy or
        *       set the candyPerChild = 1 
        *       it is important that each array slots knows rating of the array slots to the left and right
        *       in order to determine how much candy must be distributed
        *       as candies are distrubted, a variable must keep track of how many are given out
        *   what's the logic for distrubuting candies?
        *   three scenarios: (c[0] c[1], c[2]) (consider c_# to represent an array of three)
        *       c[1] rating is higher than c[0] and c[2]
        *           add a candy to c[1]
        *       c[1] rating is lower than c[0] and c[2]
        *           add a candy if none present, check c[0] and c[2] candy counts and for each, increase if necessary
        *       c[1] rating is the same as c[0] and c[2]
        *           add
        *       wait, it probably only matters what the candy behind it has? (so only examine two children)
        *           then adjust candy count accordingly
        *   Approach
        *       implementing using one for loop with two pointers to track ratings of c[0] and c[1] as well as array
        *       to store candyCounts and an counter int variable to return total candy distributed
        *   Brainstorming Time: ~10m
        *   Writing Code: ~17.5m
        *   First Submission: ~19m
        */
        int candyCount = 0;
        int[] candyPerChild = new int[ratings.length];
        for(int j = 0; j < candyPerChild.length; j++){
            candyPerChild[j] = 1;
            candyCount++;
        }
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i-1] < ratings[i]){
                while(candyPerChild[i-1] >= candyPerChild[i]){
                    candyPerChild[i]++;
                    candyCount++;
                }
            }
            if(ratings[i-1] > ratings[i]){
                while(candyPerChild[i-1] <= candyPerChild[i]){
                    candyPerChild[i-1]++;
                    candyCount++;
                }
            }
        }
        return candyCount;
    }
}

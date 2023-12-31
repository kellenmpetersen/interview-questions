//  LeetCode - 1359. Count All Valid Pickup and Delivery Options
//  https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options
//  time problem solving: 32:24 (Sep 10 2023)
//  solution consulted:
//  https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/solutions/4024280/99-57-dp-math-recursion/
//  TODO: review permutations and combinations, dynamic programming

import java.lang.Math;

class Solution {
    public int countOrders(int n) {
        /* this is a permutation / combination problem
        * best way to approach : 
        * gain intuition for problem with small sample size (n = 1-3?)
        * then extrapolate to larger n values
        * there are 2n independent events for each n value
        * for each n there is an associated pickup and a delivery
        * 1) it does not matter which order the pickups come in if they are all before the deliveries
        * 2) order of pickups and deliverys only matters if a pickup comes after its corresponding delivery
        * 3) there will never be a pickup as the final event
        * perhaps a good way to solve this problem is to calculate all the possible event orders
        * without replacement, then remove the event orders that fail the problem's criteria
        * arrays could be a good data structure to store event data with index corresponding to n
        */
        // base case
        long count = 1;
        // recursive case for the n-th event
        for(int i = 2; i <= n; i++){
            // multiply the independent events together 
            //(prev pickup / delivery combos) * (possible pickup events) * (possible delivery events)
            count = (count * (2 * i - 1) * i) % 1000000007;
        }
        return (int) count;
    }
}
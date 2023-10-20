//  LeetCode - 42. Trapping Rain Water
//  https://leetcode.com/problems/trapping-rain-water
//  time spent problem-solving: 37:06 (Oct 19 2023)
//  optimal solution consulted: https://leetcode.com/problems/trapping-rain-water/solutions/4158470/3-lines-solution-with-explaination/
//  alternative solution: https://leetcode.com/problems/trapping-rain-water/solutions/17414/a-stack-based-solution-for-reference-inspired-by-histogram/
//  alternative solution article: https://1e9.medium.com/monotonic-queue-notes-980a019d5793
//  concept: NeetCode (5/5) Two Pointers
//  TODO:   My code was passing one or two of the test cases so I thought I was close . . . unfortunately I hadn't figured out how
//          to get full-coverage of the height array, starting the two pointers from either side of the height array was viable
//          although I dismissed that possibility early on.

public class OptimalSolution {
    public int trap(int[] h) {
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);
            ans += (lmax < rmax) ? lmax - h[l++] : rmax - h[r--];
        }
        return ans;
    }
}

class MyIncorrectSolution {
    public int trap(int[] height) {
        /*  
            brainstorming: from the example it looks like the best way to solve this would be use
            two pointers to track possible rainwater storage . . . of course then one has to subtract
            the filled in squares (black on the diagram) from the total area (black & blue squares) to
            get the rain squares (blue on the diagram).

            the rain can only fill spaces that fit this elevation pattern (high-low-high), the tricky thing
            will be recognizing this pattern and calculating total rain squares (perhaps a loop for each sub-space?)

            there is a lot of spaces to calculate and each height can be 0 - 10^5 but only non-zero spaces can be
            filled with water (i.e. minimium viable space would be heights of 1, 0 ,1; creating 1 rain square)
        */
        int totalTrapped = 0;
        int start = 0, end = 1;
        while(start < end && end != height.length){
            if(height[start] > height[end]){
                end++;
            } else if(height[start] <= height[end]){
                if(height[start] != 0){
                    int trappedWater = (height[start])*(end - start);
                    int elevationToSubtract = 0;
                    for(int i = start+1; i < end; i++){
                            elevationToSubtract += height[i];
                    }
                    trappedWater -= elevationToSubtract;
                    totalTrapped += trappedWater;
                }
                start++;
                end++;
            }
        }
        return totalTrapped;
    }
}
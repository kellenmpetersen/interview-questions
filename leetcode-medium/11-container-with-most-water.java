//  LeetCode - 11. Container With Most Water
//  https://leetcode.com/problems/container-with-most-water
//  time to solve: 11:16 (Oct 19 2023)
//  optimal solution consulted: https://leetcode.com/problems/container-with-most-water/solutions/4180682/2mc-beats-100-runtime-and-memory-solution-easy-to-understand/
//  concept: NeetCode (4/5) Two Pointers
//  TODO:   The optimal solution is quite elegent, by storing the maximum area values in their own
//          seperate array and only calling Math.min() once, they are able to minimize effective runtime and memory usage.

class OptimalSolution {
    public int maxArea(int[] height) {
        if(height.length == 2) return Math.min(height[0],height[1]);

        int max = 0;
        //find the maximum height value
        for(int i : height){
            if(i > max){
                max = i;
            }
        }

        int i = 0;
        int j = height.length - 1;
        int [] values = new int[max + 1]; // array for storing areas
        int levelIndex = 0;

        //iterate each time increasing the water level
        while (i < j){
            if(height[i] <= levelIndex){
                i++;
            }else if(height[j] <= levelIndex){
                j--;
            }else{
                values[levelIndex++] = (j - i) * levelIndex;
            }
        }

        int answer = 0;
        //find the maximum area value
        for(int temp : values){
            if (temp > answer) answer = temp;
        }

        return answer;
    }
}

class MySolution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = Math.min(height[left],height[right])*(right - left);

        while(left != right){
            int totalArea = Math.min(height[left],height[right])*(right - left);
            if(totalArea > maxArea){
                maxArea = totalArea;
            }
            if(height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
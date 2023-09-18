//  LeetCode - 1337. The K Weakest Rows in a Matrix
//  https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
//  time problem solving: ~19:00 (Sep 18 2023)
//  solution consulted:
//  https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/solutions/4057683/98-41-sorting-min-heap-binary-search/
//  TODO:   learn more about heaps, lambda functions
//          visualize solution, work through codes functionality while you solve it

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] rowStrengths = new int[mat.length][2];
        for(int i = 0; i < mat.length; ++i){
            int strength = 0;
            for(int val : mat[i]){
                strength += val;
            }
            rowStrengths[i][0] = strength;
            rowStrengths[i][1] = i;
        }

        Arrays.sort(rowStrengths, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] result = new int[k];
        for(int i = 0; i < k; ++i){
            result[i] = rowStrengths[i][1];
        }
        return result;
    }
}

class IncorrectSolution {
    public int[] kWeakestRows(int[][] mat, int k) {
        /*
        *   brainstorm:
        *   1. calculuate each rows strength,
        *   store in an array?
        *   2. process each rows strength for an array
        *   of size k and swap in depending on
        *   if it is stronger (bigger = stronger;
        *   more recent if equal)
        *
        *   about 12m into solving it occured to me,
        *   why not reuse the 2-D matrix space to store row strength
        *   and their array indices?
        *   use the .sort() method to sort them based on the 2-D aspect
        */
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    mat[i][0]++;
                } else {
                    break;
                }
            }
        }
        //store number as key, index as value
        //update index as needed
        HashMap<Integer,Integer> strengthMap = new HashMap<>();
        int[] strengthArray = new int[mat.length];
        for(int i = 0; i < mat.length; i++){
            strengthMap.put(mat[0][i],i);
            strengthArray[i] = mat[0][i];
        }
        Arrays.sort(strengthArray);
        int[] kWeakestRows = new int[k];
        for(int i = 0; i < k; i++){
            kWeakestRows[i] = strengthMap.get(strengthArray[i]);
        }
        return kWeakestRows;
    }
}

//  LeetCode - 118. Pascal's Triangle
//  https://leetcode.com/problems/pascals-triangle
//  time to solve: 25:07 (Sep 7 2023)

public List<List<Integer>> generate(int numRows) {
    /*  Psuedocode Algorithm
    *   List<List<Integer>> pascalsTriangle = new List<List<Integer>>(numRows);
    *   rowSize = 1;
    *   for 0 to numRows:
    *      add a list of length rowSize to pascalsTriangle
    *      for 0 to rowSize: (traverse created list)
    *           if(prevRow(curr +1) exist && prevRow(cur - 1) exist)
    *               curr = prevRow(curr + 1) + prevRow(curr - 1)
    *           curr++
    *      increment rowSize
    *   return pascalsTriangle
    */
    List<List<Integer>> pascalsTriangle = new ArrayList<>(numRows);
    int rowSize = 1;
    ArrayList<Integer> prev = new ArrayList();
    for(int i = 0; i < numRows; i++){
        ArrayList<Integer> currRow = new ArrayList<Integer>(rowSize);
        for(int j = 0; j < rowSize; j++){
            if(!prev.isEmpty() && j > 0 && j < rowSize - 1){
                currRow.add(j, prev.get(j-1) + prev.get(j));
            } else {
                currRow.add(j, 1);
            }
        }
        prev = currRow;
        pascalsTriangle.add(currRow);
        rowSize++;
    }
    return pascalsTriangle;
}

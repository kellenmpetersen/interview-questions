//  LeetCode - 36. Valid Sudoku
//  https://leetcode.com/problems/valid-sudoku
//  time to solve: 27:54 (Oct 18 2023)
//  optimal solution consulted: https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/
//  concept: NeetCode (7/9) Arrays & Hashing
//  TODO: learn how to initalize Lists<Character> more optimally, consider more concise solutions

class OptimalSolution {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set seen = new HashSet();
            for (int i=0; i<9; ++i) {
                for (int j=0; j<9; ++j) {
                    char number = board[i][j];
                    if (number != '.')
                        if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                            return false;
                }
            }
            return true;
        }
    }
}

class MySolution {
    public boolean isValidSudoku(char[][] board) {
        List<Character> validNumbers = new ArrayList<>();
        validNumbers.add('1');
        validNumbers.add('2');
        validNumbers.add('3');
        validNumbers.add('4');
        validNumbers.add('5');
        validNumbers.add('6');
        validNumbers.add('7');
        validNumbers.add('8');
        validNumbers.add('9');

        // row checker
        for(int i = 0; i < 9; i++){
            Set<Character> checker = new HashSet<>(validNumbers);
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    boolean check = checker.remove(board[i][j]);
                    if(!check){
                        return false;
                    }
                }
            }
        }
        // column checker
        for(int i = 0; i < 9; i++){
            Set<Character> checker = new HashSet<>(validNumbers);
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    boolean check = checker.remove(board[j][i]);
                    if(!check){
                        return false;
                    }
                }
            }
        }
        // sub-box checker
        int[] subboxes = {0, 3, 6, 9};
        for(int s1 = 0; s1 < 3; s1++){
            for(int s2 = 0; s2 < 3; s2++){
                Set<Character> checker = new HashSet<>(validNumbers);
                for(int i = subboxes[s1]; i < subboxes[s1+1]; i++){
                    for(int j = subboxes[s2]; j < subboxes[s2+1]; j++){
                        if(board[i][j] != '.'){
                            boolean check = checker.remove(board[i][j]);
                            if(!check){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
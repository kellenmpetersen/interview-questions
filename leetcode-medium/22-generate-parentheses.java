//  LeetCode - 22. Generate Parentheses
//  https://leetcode.com/problems/generate-parentheses
//  time spent problem solving: ~15:00 (Nov 3 2023)
//  optimal solution consulted: https://leetcode.com/problems/generate-parentheses/solutions/10100/easy-to-understand-java-backtracking-solution/
//  concept: NeetCode (4/7) Stack
//  TODO:   I was stumped on this one. I knew the DS to mimic (Stack) and understood the set of possibilties would be limited to length 2n
//          (where n is equal to the number of paretheses sets) and the valid conditions being the number of closing parentheses would always need
//          to be less than the opening ones. However, implementing it was tricky and I need to familarize myself with more backtracking problems.

class OptimalSolution {
    public List<String> generateParenthesis(int n) {
        //  problem-solving process: well I'm stumped. I see theres a general pattern and that its a matter of combinatorics
        //  but despite knowing the answer involves the Stack data structure to maintain parity between
        //  opening and closing brackets, I'm not sure how to devise a complete set for n number of parentheses sets.
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }

    public void backtrack(List<String>list, String str, int open, int close, int max){
        if(str.length() == max * 2){
            list.add(str);
            return;
        }

        if(open < max){
            backtrack(list, str+"(",open+1, close, max);
        }
        if(close < open){
            backtrack(list, str+")", open, close+1, max);
        }
    }
}
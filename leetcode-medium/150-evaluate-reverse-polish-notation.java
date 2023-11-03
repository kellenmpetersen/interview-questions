//  LeetCode - 150. Evaluate Reverse Polish Notation
//  https://leetcode.com/problems/evaluate-reverse-polish-notation
//  time spent problem solving: ~30:00 (Nov 3 2023)
//  optimal solution consulted: https://leetcode.com/problems/evaluate-reverse-polish-notation/solutions/1229403/js-python-java-c-easy-stack-solution-w-explanation/
//  concept: NeetCode (3/7) Stack
//  TODO:   I'd solved this problem before for a calculator project so it was interesting to revisit it.
//          The key is to store the answer on the stack and evaluate the operations as needed.
//          Any number should be pushed to the stack for later evaluation.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1 = 0, num2 = 0;
        for(String token : tokens){
            if(token.equals("+")){
                num1 = stack.pop();
                num2 = stack.pop();
                num1 += num2;
                stack.push(num1);
            } else if(token.equals("-")){
                num2 = stack.pop();
                num1 = stack.pop();
                num1 -= num2;
                stack.push(num1);
            } else if(token.equals("*")){
                num1 = stack.pop();
                num2 = stack.pop();
                num1 *= num2;
                stack.push(num1);
            } else if(token.equals("/")){
                num2 = stack.pop();
                num1 = stack.pop();
                num1 /= num2;
                stack.push(num1);
            } else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
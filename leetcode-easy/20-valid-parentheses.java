//  LeetCode - 20. Valid Parentheses
//  https://leetcode.com/problems/valid-parentheses
//  time to solve: 22:55 (Oct 20 2023)
//  optimal solution consulted: https://leetcode.com/problems/valid-parentheses/solutions/9178/short-java-solution/
//  concept: NeetCode (1/7) Stack
//  TODO:   get more Stack practice, also see if I think of ways to simplify as I execute instead of
//          just worrying about solving the problem as quickly as possible.

class OptimalSolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if(c == '{'){
                stack.push('}');
            } else if(c == '['){
                stack.push(']');
            } else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

class MySolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char b = s.charAt(i);
            if(isStartingBracket(b) || stack.empty()){
                stack.push(b);
            } else {
                if(!stack.empty() && stack.pop() != reverseBracket(b)){
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        } else {
            return false;
        }
    }

    public boolean isStartingBracket(char b){
        if(b == '(' || b == '{' || b == '['){
            return true;
        } else {
            return false;
        }
    }

    public char reverseBracket(char b){
        if(b == ')'){
            return '(';
        } else if(b == '}'){
            return '{';
        } else if(b == ']'){
            return '[';
        } else {
            return b;
        }
    }
}
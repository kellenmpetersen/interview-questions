//  LeetCode - 155. Min Stack
//  https://leetcode.com/problems/min-stack
//  time spent problem solving: ~45:00 (Oct 31 2023)
//  optimal solution consulted: https://leetcode.com/problems/min-stack/solutions/49014/java-accepted-solution-using-one-stack/
//  concept: NeetCode (2/7) Stack
//  TODO:   figure out how to use stack effectively. the key concept here was wrapping
//          a stack to track the minimum by storing the current minimum on the stack as well.
//          Like LinkedList traversal, Stack traversal is an important concept to grasp.

class OptimalMinStack {

    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

class MyIncorrectMinStack {

    private ArrayList minStack;

    private int lastIndex;

    private Stack<Integer> min;

    public MinStack() {
        this.minStack = new ArrayList<>();
        this.lastIndex = -1;
        this.min = new Stack<Integer>();
    }
    
    public void push(int val) {
        lastIndex++;
        if(lastIndex == 0){
            min.push(val);
        } else if(val < min.peek()){
            min.push(val);
        }
        minStack.add(lastIndex,val);
    }
    
    public void pop() {
        int removedElement = (int)minStack.remove(lastIndex);
        if(removedElement == min.peek()){
            min.pop();
        }
        lastIndex--;
    }
    
    public int top() {
        return (int)minStack.get(lastIndex);
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
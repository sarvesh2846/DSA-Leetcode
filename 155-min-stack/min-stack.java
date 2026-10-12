/*
Constraint => getMin() => TC : O(1) 
// APPROACH 1ST => SC: 2*n
// Uses the Stack of pair which store the value and track the curr minVal 
import java.util.Stack;

class MinStack {

    static class pair{
        int first;
        int currentMin;
        public pair(int first, int currentMin){
            this.first = first;
            this.currentMin = currentMin;
        }
    }
    
    Stack<pair> s = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int value) {
        if(s.isEmpty()){
            s.push(new pair(value, value));
        } 
        else {
            int minVal = Math.min(value, s.peek().currentMin);
            s.push(val, minVal);
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().first;
    }
    
    public int getMin() {
        return s.peek().currentMin;
    }
}
*/

// APPROACH 2ND => SC: n
import java.util.Stack;

class MinStack {

//==========LAST minVal CALCULATION======================

    // Push Operation
    //value = 2 * currVal - currMinVal;
    //minVal = value

    //Pop Operation
    //MinVal = 2 * oldMinval - currPeekValue


//======================================================

    Stack<Long> s = new Stack<>();
    long minVal;

    public MinStack() {
        // no need of contructor creation 
        // loading instructions
    }
    
    public void push(int value) {
        // Nothing into Stack
        if(s.isEmpty()){
            s.push((long)value);
            minVal = value;
        }
        // Stack having elements then calculate the pushVal and minVal then push to Stack
        else {

            // if value is smaller
            if(value < minVal){
                s.push(2L * value - minVal);
                minVal = value;
            }
            // if value is greater
            else {
                s.push((long)value);
            }
        }
    }

    public void pop() {
        // calculate the PREV minVal using currMinval and currVal
        long curr = s.peek();

        if(curr < minVal){
            minVal = 2L * minVal - s.peek();
        }

        s.pop();
    }
    
    public int top() {
        // return minVal if greater otherwise peek value
        long curr = s.peek();
 
        if(curr < minVal){
            return (int)minVal;
        }
        return (int)curr;
    }
    
    public int getMin() {
        return (int)minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
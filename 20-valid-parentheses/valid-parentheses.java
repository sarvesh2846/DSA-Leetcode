import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            // For opening
            if(s.charAt(i) == '(' || 
            s.charAt(i) == '{' || 
            s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){ //for close there is not open
                    return false;
                }
                //close match
                if((st.peek() == '(' && s.charAt(i) == ')')||
                (st.peek() == '{' && s.charAt(i) == '}')||
                (st.peek() == '[' && s.charAt(i) == ']' )){
                    st.pop();
                }
                else{
                    return false; // close not match
                }
            }
        }
        // all MATCH satisfied
        return st.size() == 0; 
    }
}
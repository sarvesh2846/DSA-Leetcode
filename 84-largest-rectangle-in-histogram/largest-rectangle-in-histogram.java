import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;;
        int left[] = new int[n]; // left smaller nearest
        int right[] = new int[n]; // right smaller nearest

        Stack<Integer> s = new Stack<>();

        //Right smaller 
        for(int i = n-1; i >= 0; i--){
            while(s.size() > 0 && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        // After finding rigth smaller if some elements are remain in stack  then we remove it from the stack & make Empty
        while(!s.isEmpty()){
            s.pop();
        }

        //Left smaller
        for(int i = 0; i < n; i++){
            while(s.size() > 0 && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            int currArea = heights[i] * width;
            ans = Math.max(ans, currArea);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
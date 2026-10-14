import java.util.*;
// Index Access in 2nd CPY array of 1st array: i % n
// Circular array => consider it as same cpy of array next to it then find NG for entire arr
// store result using IDX into ans arr & return it
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 2*n-1; i >= 0; i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i % n]){
                s.pop();
            }

            ans[i % n] = s.isEmpty() ? -1 : nums[s.peek()];
            s.push(i % n);
        }
        return ans;
    }
}
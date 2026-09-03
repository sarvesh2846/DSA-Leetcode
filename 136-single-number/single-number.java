class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        
        // ^ => BITWISE XOR
        //duplicate no will get cancel out with their binary no 
        for(int val : nums){
            ans ^= val;
        }
        return ans;
    }
}
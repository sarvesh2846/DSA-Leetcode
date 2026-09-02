class Solution {
    public int majorityElement(int[] nums) {
        int freq = 0, ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(freq == 0){
                ans = nums[i];
            }
            if(ans == nums[i]){
                ++freq;
            }
            else{
                --freq;
            }
        }
        
        // If ans is not Exists of All time 
        int count = 0;
        for(int val : nums){
            if(val == ans){
                ++count;
            }
        }
        return (count > nums.length / 2) ? ans : -1;  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
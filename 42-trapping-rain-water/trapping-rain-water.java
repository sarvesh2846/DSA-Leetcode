class Solution {
    public int trap(int[] height) {
        int ans = 0, n = height.length;
        int l = 0, r = n-1;
        int leftMax = 0 , rightMax = 0;

        while(l < r){
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            if(leftMax < rightMax){
                ans += leftMax - height[l];
                l++;
            }
            else{
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
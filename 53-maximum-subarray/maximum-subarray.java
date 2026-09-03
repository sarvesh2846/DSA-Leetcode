class Solution {
    public int maxSubArray(int[] nums) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        int maxNegative =  Integer.MIN_VALUE;
        boolean allNegative = true;

        for(int val : nums){
            if(val >= 0){
                allNegative = false;
                break;
            }
            else{
                if(val > maxNegative){
                    maxNegative = val;
                }
            }
        }

        if (allNegative) {
            return maxNegative;
        }

        for(int val : nums){
            cs += val;
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        return ms;
    }
}
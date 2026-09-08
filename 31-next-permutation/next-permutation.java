class Solution {
    public void nextPermutation(int[] nums) {
        // find the pivot 
        int pivot = -1, n = nums.length;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }

        // If elements are in decresing order...
        if(pivot == -1){

            int left = 0;
            int right = nums.length - 1;

            while (left < right) {  // in the places changes 
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
            return;
        }

        //2nd step : next larger element

        for(int i = n-1; i > pivot; i--){
            if(nums[i] > nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        //3rd step : reverse (piv+1 to n-1)
        int i = pivot+1, j = n-1;

        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
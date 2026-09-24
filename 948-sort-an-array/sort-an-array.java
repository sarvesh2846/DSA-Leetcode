class Solution {
    public static void mergeSort(int[] arr, int si, int ei){
        //base case 
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;

        //kaam
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid, ei);
        
    }
    public static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } 
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //left
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        //right
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        //transfer
        for(k=0, i=si; k<temp.length; k++, i++){  
            arr[i] = temp[k];                     
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}
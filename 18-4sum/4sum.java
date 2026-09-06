import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]){  //optimization
                continue;
            }
            for(int j = i+1; j < n;){
                int p = j+1, q = n-1;

                while(p < q){ // type cast (long)
                    long sum = (long) nums[i] + (long)nums[j] + (long)nums[p] + (long)nums[q];

                    if(sum < target){
                        p++;
                    }
                    else if(sum > target){
                        q--;
                    }
                    else{ // sum == target
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[p],nums[q])));
                        p++;
                        q--;

                        while(p < q && nums[p] == nums[p-1]){  //optimization
                            p++;
                        }
                    }       
                }
                j++;
                while(j < n && nums[j] == nums[j-1]){  //optimization
                    j++;
                }
            }
        }
    return ans;   
    }
}
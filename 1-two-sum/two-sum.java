import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            //required element
            int complement = target - nums[i];
             
            //Check that required available in previous numbers in HashMap
            if (map.containsKey(complement)) {
                //yess then return their index and 2nd no index
                return new int[] { map.get(complement), i };
            }
            //otherwise add the no with their index into HashMap
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
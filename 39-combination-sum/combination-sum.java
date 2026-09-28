import java.util.*;

class Solution {
    
    static Set<List<Integer>> set = new HashSet<>();

    public static void getAllCombinations(int[] arr, int idx, int target, List<Integer> combin, List<List<Integer>> ans){
        //base case 
        if(idx == arr.length || target < 0){ // arr is over & target becomes negative
            return;
        }

        if(target == 0){ // target List is founded
            if(!set.contains(combin)){
                ans.add(new ArrayList<>(combin));
                set.add(new ArrayList<>(combin));
            }
            return;    
        }

        combin.add(arr[idx]); // element added

        //single
        getAllCombinations(arr, idx+1, target-arr[idx], combin, ans);

        //multiple
         getAllCombinations(arr, idx, target-arr[idx], combin, ans);
        
        combin.remove(combin.size()-1); // backtrack & remove ele make list empty 

        //exclude
         getAllCombinations(arr, idx+1, target, combin, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        set.clear();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();

        getAllCombinations(candidates, 0, target, combin, ans);

        return ans;
    }
}
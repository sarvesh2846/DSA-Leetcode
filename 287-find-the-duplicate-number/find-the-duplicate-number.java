class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        // 2nd occurence of duplicate element
        do{
            slow = nums[slow]; // +1
            fast = nums[nums[fast]]; //+2
        } while(slow != fast);

        slow = nums[0];

        //1st occurence of duplicate element
        while(slow != fast){
            slow = nums[slow]; //+1
            fast = nums[fast]; //+1
        }
        return slow;
        // return fast; => Both are poiting to same element
    }
}
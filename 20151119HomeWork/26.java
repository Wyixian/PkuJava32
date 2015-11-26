public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int count = 1;
        for(int i = 0; i < len-1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[count] = nums[i+1];
                count++;
            }
        }
        return count;
    }
}
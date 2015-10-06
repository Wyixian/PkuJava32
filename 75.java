public class Solution {
    public static void sortColors(int[] nums) {
        int len = nums.length;
        int tmp = 0;
        for(int i=0; i < len-1; i++) {
            for(int j=0; j < len-i-1; j++) {
                if(nums[j] > nums[j+1]) {
                    tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
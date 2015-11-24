public class Solution {
    public int removeDuplicates(int[] nums) {
        // if(nums.length == 0){
        //     return null;
        // }else
        if(nums.length == 1){
            return 1;
        }
        int result = 1;
        int temp = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                temp++;
                continue;
            }else{
                result++;
                nums[i-temp] = nums[i];
            }
        }
        return result;
    }
}
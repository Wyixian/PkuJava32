public class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        if(nums.length == 1){
            return result;
        }
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] == nums[i]){
                result = true;
                return result;
            }else{
                continue;
            }
        }
        return result;
    }
    
}
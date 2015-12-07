public class Solution {
    public void moveZeroes(int[] nums) {
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                temp++;
            }else{
                nums[i-temp] = nums[i];
                //nums[i] = 0;
            }
        }
        if(temp != 0){
            for(int i=nums.length-temp;i<nums.length;i++){
                nums[i] = 0;
            }
        }
        
    }
}
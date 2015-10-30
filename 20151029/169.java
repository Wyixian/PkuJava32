public class Solution {
    public int majorityElement(int[] nums) {
        //方法一 O(nlogn)
        Arrays.sort(nums);
        return nums[nums.length/2];
        
        //方法二 O(n)
        // int result = nums[0];
        // int temp = 1;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i] == result){
        //         temp++;
        //     }else{
        //         temp--;
        //         if(temp == 0){
        //             result = nums[i];
        //             temp++;
        //         }
        //     }
        // }
        // return result;
        
    }
}
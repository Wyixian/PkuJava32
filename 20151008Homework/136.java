public class Solution {
    public int singleNumber(int[] nums) {
        //数组中找出只出现一次的数字,想破脑袋后......参考大神的解法
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
        
        // int result = -1;
        // int[] count = new int[1000];
        // for(int i=0;i<nums.length;i++){
        //     ++count[nums[i]];
        // }
        // for(int j=0;j<count.length;j++){
        //     if(count[j] == 1){
        //         result = j;
        //     }
        // }
        // return result;
    }
}
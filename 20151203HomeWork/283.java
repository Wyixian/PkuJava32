public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int firstZero = -1;      //remark the first location of 0, biginning with -1
        int tmp;           //数组中交换两个数时用于中间缓存
        for(int i=0; i<len; i++) {
            if(nums[i] != 0) {
                if(firstZero >= 0) {
                    tmp = nums[i];
                    nums[i] = nums[firstZero];
                    nums[firstZero] = tmp;
                    firstZero++;   //now, the firstZero should move to next
                }
            } else {
                if(firstZero < 0) firstZero = i;
            }
        }
    }
}
public class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        int[] tmp = new int[k];
        for(int i = 0; i < k; i++) {
            tmp[i] = nums[size - k + i];
        }
        for(int i = 0; i < size; i++) {
            if(size-k > i) {
                nums[size-i-1] = nums[size-k-i-1];
            }
            else
                nums[size-i-1] = tmp[size-i-1];
        }
    }
}
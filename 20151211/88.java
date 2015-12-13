public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //不创建新的数组,倒序比较
        int nums1_num = m-1;
        int nums2_num = n-1;
        int k = nums1.length;
        while(nums1_num>=0 & nums2_num>=0){
            k--;
            if(nums1[nums1_num] >= nums2[nums2_num]){
                nums1[k] = nums1[nums1_num];
                //k--;
                nums1_num--;
            }else{
                nums1[k] = nums2[nums2_num];
                //k--
                nums2_num--;
            }
        }
        if(nums1_num < 0){
            //nums1初始值已遍历完毕
            for(int i=nums2_num;i>=0;i--){
                k--;
                nums1[k] = nums2[i];
            }
        }else{
            //nums2初始值已遍历完毕
            for(int i=nums1_num;i>=0;i--){
                k--;
                nums1[k] = nums1[i];
            }
        }
    }
}
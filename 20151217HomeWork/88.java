public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        for(int i=0, i1=0, i2=0; i<m+n; i++) {
            if(i2<n) {
                if(i1<m && nums1[i1] <= nums2[i2]) {
                    nums3[i] = nums1[i1];
                    i1++;
                }
                else {
                    nums3[i] = nums2[i2];
                    i2++;
                }
            } else {
                nums3[i] = nums1[i1];
                i1++;
            }
        }
        for(int i=0; i<m+n; i++) {
            nums1[i] = nums3[i];
        }
    }
}
public class Solution {
    public static void sortColors(int[] nums) {
        /*int len = nums.length;    //ð�����򲻷���Ҫ��
        int tmp = 0;        for(int i=0; i < len-1; i++) {
            for(int j=0; j < len-i-1; j++) {
                if(nums[j] > nums[j+1]) {
                    tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }*/
        int len = nums.length;
        int[] tmp = new int[len];
        for(int i = 0; i < len; i++) {      //��ʼ������Ϊ1
            tmp[i] = 1;
        }
        int first = 0, last = len - 1;
        for(int i=0; i<len; i++) {          //����һ��
            if(nums[i] == 0) tmp[first++] = 0;
            else if(nums[i] == 2) tmp[last--] = 2;
        }
        //nums = Arrays.copyOf(tmp, len);     
        for(int i=0; i<len; i++) {
            nums[i] = tmp[i];
        }
    }
}
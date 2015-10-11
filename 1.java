public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index1 = 0;
        int index2 = 0;
        //sort(nums,0,nums.length-1);
        int[] nums_sort = new int[nums.length];
        System.arraycopy(nums,0,nums_sort,0,nums_sort.length);
        //Arrays.sort(nums);
        Arrays.sort(nums_sort);
        //int temp1 = -1;
        //int temp2 = -1;
        int i = 0;
        int j = nums_sort.length-1;
        int[] index = new int[2];
        while(i<j){
            if(target > nums_sort[i] + nums_sort[j]){
                i++;
            }else if(target < nums_sort[i] + nums_sort[j]){
                j--;
            }else{
                index[0] = nums_sort[i];
                index[1] = nums_sort[j];
                //temp1 = nums_sort[i];
                //temp2 = nums_sort[j];
                break;
            }
        }
        for(int k=0;k<nums.length;k++){
            if(index[0] == nums[k] && index1 == 0){
                index1 = k + 1;
            }else if(index[1] == nums[k] && index2 == 0){
                index2 = k + 1;
            }
        }
        index[0] = index1;
        index[1] = index2;
        Arrays.sort(index);
        return index;
    }
    // //二分归并排序
    // private static void sort(int[] nums,int i,int j){
    //     if(i<j){
    //         int mid = (i+j)/2;
    //         sort(nums,i,mid);
    //         sort(nums,mid+1,j);
    //         merge(nums,i,mid,j);
    //     }
    // }
    // //合并数组
    // private static void merge(int[] nums,int i,int mid,int j){
    //     int[] temp = new int[nums.length];
    //     int m = i;
    //     int n = mid + 1;
    //     int k = i;
    //     while(m<=mid && n<=j){
    //         if(nums[m] < nums[n]){
    //             temp[k++] = nums[m++];
    //         }else{}
    //             temp[k++] = nums[n++];
    //     }
    //     while(m<=mid){
    //         temp[k++] = nums[m++];
    //     }
    //     while(n<=j){
    //         temp[k++] = nums[n++];
    //     }
    //     while(i<=j){
    //         nums[i] = temp[i++];
    //     }
    // }
    
}
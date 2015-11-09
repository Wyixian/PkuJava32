public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list1 = new ArrayList<List<Integer>>();
        //排序
        Arrays.sort(nums);
        //第一个数
        for(int i=0;i<=nums.length-4;i++){
            //去除重复
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            //第二个数
            for(int j=i+1;j<=nums.length-3;j++){
                //第三个数
                int start = j+1;
                //第四个数
                int end = nums.length-1;
                while(start < end){
                    if((target - nums[i] - nums[j]) > (nums[start] + nums[end])){
                        start++;
                    }else if((target - nums[i] - nums[j]) < (nums[start] + nums[end])){
                        end--;
                    }else{
                        List<Integer> list=new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        list1.add(list);
                        //去除重复
                        while(start < end && nums[start]==nums[start+1]){
                            start++;
                        }
                        while(start <end && nums[end]==nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }
                }
                //去除重复
                while(j<nums.length-3 && nums[j] == nums[j+1]){
                    j++;
                }
            }
        }
        return list1; 
    }
}
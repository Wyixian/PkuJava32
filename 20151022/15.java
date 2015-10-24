public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //List<Integer> list=new ArrayList<Integer>();
        List<List<Integer>> list1=new ArrayList<List<Integer>>();
        //int index=0;
        //排序
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            int start = i+1;
            int end = nums.length-1;
            //去掉重复
            //while(i>0 && i<nums.length-3 && nums[i] == nums[i-1]){
            //  i++;
            //}
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            //前后指针寻找其余两个值
            while(start < end){
                if(nums[start] + nums[end] < (0 - nums[i])){
                    start++;
                }else if(nums[start] + nums[end] > (0 - nums[i])){
                    end--;
                }else{
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    //list1.add(index,list);
                    //index++;
                    list1.add(list);
                    //去掉重复
                    while(start < end && nums[start] == nums[start+1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }
            }
        }
        return list1 ;
    }
}
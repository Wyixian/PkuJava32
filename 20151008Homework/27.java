public class Solution {
    public int removeElement(int[] nums, int val) {
        // if(nums.length == 0){
        //     return 0;
        // }else{
        ArrayList<Integer> templist = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                templist.add(nums[i]);
            }
        }
        for(int j=0;j<templist.size();j++){
            //nums[j] = templist(j);
            nums[j] = templist.get(j);
        }
        return templist.size();
        //}
        
        
        
        
        //大神解法
        // int removeCount = 0;
        // for(int i = 0 ; i < A.length ; i++){
        //     if(A[i] == elem){
        //         removeCount++;
        //     }else{
        //         A[i - removeCount] = A[i];
        // }
        // return A.length - removeCount;
    }
}
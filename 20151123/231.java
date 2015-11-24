public class Solution {
    //2进制表达中,有且仅有一个1
    public boolean isPowerOfTwo(int n) {
        //有且仅有一个1，则以2为底n的对数结果是整数。-------哪里不对？？？？
        //         boolean result = false;
        //         double temp = Math.log(n) / Math.log(2);
        //         int temp_new = (int)(temp);
        // 		if(temp_new == temp){
        // 			result = true;
        // 		}
        //         return result;
        //利用十进制数转化成二进制数的过程
        boolean result = false;
        int count = 0;
        while(n != 0){
            if(n%2 == 1){
                count++;
            }
            n = n/2;
        }
        if(count == 1){
            result = true;
        }
        return result;
        
        
        
    }
}
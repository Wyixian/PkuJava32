public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int count = 0;
        // for(int i=n;i!=0;i=i/2)
        // if(i%2 == 1){
        //     count++;
        // // }
        
        int result = 0;
        while (n != 0) {
            result  = result + (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
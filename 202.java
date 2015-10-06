public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<Integer>();
        int sum;
        // if(sum != 1){
        //     sum = sum + n%10 * n%10;
        // }
        while(n != 1){
            sum = 0;
            while(n != 0){
                //sum = 0;
                if(n>=10){
                    sum =  sum + (n%10) * (n%10);
                    n = n/10;
                }else{
                    sum = sum + n*n;
                    n = n/10;
                    // if(sum == 1){
                    //     return True;
                    // }else{
                    //     n = sum;
                    //     sum = 0;
                    // }
                }
            }
            if(hash.contains(sum)){
                return false;
            }
            else{
                hash.add(n = sum);
            }
        }
        return true;
        // if(sum == 1)
        //     return TRUE;
    }
}
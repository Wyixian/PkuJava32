public class Solution {
    public int countPrimes(int n) {
        //求小于n的素数个数
        //将可以由n1*n2得到的数全部去除掉
        if(n <= 2){
            return 0;
        }else if(n == 3){
            return 1;
        }
        boolean[] temp = new boolean[n];
        for(int i=2;i*i<n;i++){
            for(int j=i;i*j<n;j++){
                temp[i*j] = true;
            } 
        }
        int result = 0;
        for(int i=2;i<n;i++){
            if(temp[i] == false){
                result++;
            }
        }
        return result;
    }
}
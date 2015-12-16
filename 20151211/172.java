public class Solution {
    public int trailingZeroes(int n) {
        //Note: Your solution should be in logarithmic time complexity.对数时间完成
        
        //可以产生0的的乘法情况有：     2*5，10*n，15*2，20*n，25*2，30*n......
        //上述情况分别可以产生0的个数为：1， 2，   3，   4，   6，   7
        //n!的结尾有几个0 ==> n中包含几个5（注：25=5*5，等价于有两个5）
        int result = 0;
        while(n != 0){
            result = result + n/5;
            n = n/5;
        }
        return result;
    }
}
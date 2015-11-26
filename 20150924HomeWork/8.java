public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        if(len < 1) return 0;
        int flag = 1;
        int count = 0;
        double result = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+') {
            if(str.charAt(0) == '-')
                flag = -1;
            count++;
        }
        for(int i=count; i<len; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                result = result * 10 + str.charAt(i) - '0';
            else break;
        }
        result = flag * result;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)result;
    }
}
public class Solution {
    public int titleToNumber(String s) {
        //s.charAt(i) ==> A--Z
        //int temp = s.charAt(i) ==> 65--90
        int result = 0;
        for(int i=0;i<s.length();i++){
            result = result * 26 +s.charAt(i) - 64;
        }
        return result;
    }
}
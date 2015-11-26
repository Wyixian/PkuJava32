public class Solution {
    public static int titleToNumber(String s) {
        int colNumber=0; char[] chars=s.toCharArray(); int l=chars.length;
        for(int i=0;i<l;i++) colNumber+=(chars[i]-64)*Math.pow(26,l-1-i);
        return colNumber;
    }
}
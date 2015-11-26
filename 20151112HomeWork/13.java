public class Solution {
/*从后往前扫描，用一个临时变量记录分段数字。
如果当前处理的字符对应的值和上一个字符一样，那么临时变量加上这个字符。比如III = 3
如果当前比前一个大，说明这一段的值应该是当前这个值减去前面记录下的临时变量中的值。比如IIV = 5 – 2
如果当前比前一个小，那么就可以先将临时变量的值加到结果中，然后开始下一段记录。比如VI = 5 + 1*/
    public int romanToInt(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int sum = getRomanValue(s.charAt(len-1));
        for(int i=len-2; i>=0; i--) {
            int pre = getRomanValue(s.charAt(i));
            int cur = getRomanValue(s.charAt(i+1));
            if(pre >= cur) {
                sum += pre;
            } else {
                sum -= pre;
            }
        }
        return sum;
    }
    public int getRomanValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
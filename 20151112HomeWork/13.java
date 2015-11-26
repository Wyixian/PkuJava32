public class Solution {
/*�Ӻ���ǰɨ�裬��һ����ʱ������¼�ֶ����֡�
�����ǰ������ַ���Ӧ��ֵ����һ���ַ�һ������ô��ʱ������������ַ�������III = 3
�����ǰ��ǰһ����˵����һ�ε�ֵӦ���ǵ�ǰ���ֵ��ȥǰ���¼�µ���ʱ�����е�ֵ������IIV = 5 �C 2
�����ǰ��ǰһ��С����ô�Ϳ����Ƚ���ʱ������ֵ�ӵ�����У�Ȼ��ʼ��һ�μ�¼������VI = 5 + 1*/
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
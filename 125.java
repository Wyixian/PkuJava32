public class Solution {
    //仅存在符号时返回true,为此设置一个flag,当flag未进入循环时,flag=true.
    public boolean isPalindrome(String s) {
        boolean flag = true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
        	char tmp = s.charAt(i);
        	if(tmp>='a' && tmp<='z' || tmp>='0' && tmp<='9') {
        	    flag = false;
        		sb.append(tmp);
        	}
        }
        if(flag) return true;
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }
}
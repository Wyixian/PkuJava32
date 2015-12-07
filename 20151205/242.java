public class Solution {
    public boolean isAnagram(String s, String t) {
        //s和t中，相同字符是否出现了同样的次数，并且没有多余的字符
        String[] ss = s.split("");
        Arrays.sort(ss);
        String[] tt = t.split("");
        Arrays.sort(tt);
        if(Arrays.equals(ss,tt)){
            return true;
        }else{
            return false;
        }
    }
}
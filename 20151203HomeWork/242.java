public class Solution {
    public static boolean isAnagram(String s, String t) {
        int[] count1 = new int[26];
        for(int i=0; i<s.length(); i++)
        	count1[s.charAt(i)-'a']++;
        for(int i=0; i<t.length(); i++)
        	count1[t.charAt(i)-'a']--;
        for(int i=0; i<26; i++)
        	if(count1[i] != 0) return false;
        return true;
    }
}
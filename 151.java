public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0){
            return "";
        }else{
            int n = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == ' '){
                    n++;
                }
            }
            String[] a = new String[n+1];
            //a = s.split(" ");
            a = s.split("\\s+");
            //a = s.replaceAll("\\s*", "");
            StringBuffer buffer = new StringBuffer();
            for(int i=a.length-1;i>=0;i--){
                buffer.append(a[i] + " ");
            }
            //buffer = buffer.deleteCharAt(buffer.length()-1);
            String result = buffer.toString().trim();
            return result;
        }
    }
}
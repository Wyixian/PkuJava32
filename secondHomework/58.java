public class Solution {
    public int lengthOfLastWord(String s) {
        // if(" ".equals(s.substring(s.length()-1))){
        //     return 0;
        // }else{
        //     int n=0;
        //     for(int i=0;i<s.length();i++){
        //         if(s.charAt(i) == ' '){
        //             n++;
        //         }
        //     }
        //     String[] temp = new String[n+1];
        //     temp = s.split(" ");
        //     return temp[n].length();
        // }
        if("".equals(s)){
            return 0;
        }else{
            int n=0;
            s = s.trim();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == ' '){
                    n++;
                }
            }
            String[] temp = new String[n+1];
            temp = s.split(" ");
            return temp[n].length();
        }
        // if(temp[n].length() == 0){
        //     return 0;
        // }else{
        //     return temp[n].length();
        // }
    }
}
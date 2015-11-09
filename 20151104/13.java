public class Solution {
    public int romanToInt(String s) {
        // 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // 1000~3000: {"M", "MM", "MMM"}.
        //I:1,V:5,X:10,L:50,C:100,D:500,M:1000
        //分析找规律(正确值，按位累加值)：
        //IV-->(4,6),IX-->(9,11),XL-->(40,60),XC-->(90,110),CD-->(400,600),CM-->(900,1100)
        //I+V-2I     I+X-2I      X+L-2X       X+C-2X        C+D-2C         C+M-2C
        Solution solution = new Solution();
        int result = solution.toInt(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if( solution.toInt(s.charAt(i)) > solution.toInt(s.charAt(i-1)) ){
                result = result + solution.toInt(s.charAt(i)) - 2*solution.toInt(s.charAt(i-1));
            }else{
                result = result + solution.toInt(s.charAt(i));
            }
        }
        return result;
    }
    
    public int toInt(char temp){
        switch(temp){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
}
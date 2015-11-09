public class Solution {
    public String intToRoman(int num) {
        // 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // 1000~3000: {"M", "MM", "MMM"}.
        // //I:1,V:5,X:10,L:50,C:100,D:500,M:1000
        String[][] roman = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        };
        String result = "";
        int i = 0;
        int j;
        while(num!=0){
            j = num % 10;
            //result = result.insert(0,roman[i][j]);
            result = roman[i][j] + result;
            i++;
            num = num/10;
        }
        return result;
        
        
        
        // String result = null;
        // int temp;
        // int n = 0;
        // while(num!=0){
        //     n++;
        //     temp =  num % 10;
        //     num = num/10;
        //     if(temp>0 && temp<4){
        //     //"I", "II", "III","X", "XX", "XXX","C", "CC", "CCC","M", "MM", "MMM"
        //         if(n==1){
        //             for(int i=0;i<temp;i++){
        //                 result.insert(0,"I");
        //             }
        //         }else if(n==2){
        //             for(int i=0;i<temp;i++){
        //                 result.insert(0,"X");
        //             }
        //         }else if(n==3){
        //             for(int i=0;i<temp;i++){
        //                 result.insert(0,"C");
        //             }
        //         }else{
        //             for(int i=0;i<temp;i++){
        //                 result.insert(0,"M");
        //             }
        //         }
        //     }else if(temp==4){
        //     //"IV", "XL","CD"
        //         if(n==1){
        //             result.insert(0,"IV");
        //         }else if(n==2){
        //             result.insert(0,"XL");
        //         }else{
        //             result.insert(0,"CD");
        //         }
        //     }else if(temp>4){
        //     //"V", "VI", "VII", "VIII", "IX"
        //         if(n==1){
        //             for(int i=5;i<temp;i++){
        //                 result.insert(0,"I");
        //             }
        //             result.insert(0,"V");
        //         }
        //     //"L", "LX", "LXX", "LXXX", "XC"
        //     //"D", "DC", "DCC", "DCCC", "CM"
        
        //     }else{
        //     //temp==0
        //     }
        
        // }
    }
}
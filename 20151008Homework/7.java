public class Solution {
    public int reverse(int x) {
        int result = 0;
        if(x != 0){
            int xx = Math.abs(x);
            //   if(if(result>(Integer.MAX_VALUE-xx%10)/10) {
            //       return 0;
            //   }else{
            while(xx > 0){
                //if((result * 10 + xx % 10) > Integer.MAX_VALUE)
                if( result>(Integer.MAX_VALUE-xx%10)/10){
                    return 0;
                }
                int temp = 0;
                temp = xx % 10;
                xx = xx / 10;
                result = result * 10 + temp;
            }
            if(x < 0){
                result = -result;
            }
            return result;
            // }
        }else{
            return result;
        }
        // Stack<Integer> stack = new Stack<Integer>();
        // int count = 0;
        // if(x != 0){
        //     int xx = Math.abs(x);
        //     int xx1 = Math.abs(x);
        //     while(xx1 != 0){
        //         //stack.push(x % 10);
        // 	    count++;
        // 	    xx1 = xx1/10;
        //     }
        //     int N = count-1;
        //     int[] num = new int[count];
        //     int i = 0;
        //     while(xx > 10){
        //         count--;
        //         num[i] = xx / (int)(Math.pow(10,count));
        //         xx = xx - num[i] * (int)(Math.pow(10,count));
        //         i++;
        //     }
        //     num[i] = xx;
        //     for(int j=0;j<num.length;j++){
        //         stack.push(num[j]);
        //     }
        //     int result= 0;
        //     for(int k=0;k<num.length;k++){
        // 	    //System.out.print(stack.pop());
        // 	    result += stack.pop() * (int)(Math.pow(10,N));
        // 	    N--;
        //     }
        //     if(x<0){
        //         //stack.push("-");
        //         //System.out.print("-");
        //         result = -result;
        //     }
        //     return result;
        // }else{
        //     //System.out.print("0");
        //     return 0;
        // }
    }
}
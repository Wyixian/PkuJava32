public class Solution {
    public int maxProfit(int[] prices) {
        //价格最低的时候买，价格最高的时候卖,买价的日期早于卖价的日期
        
        //超时
        // int maximum = 0;
        // for(int i=0;i<prices.length-1;i++){
        //     for(int j=i+1;j<prices.length;j++){
        //         if((prices[j] - prices[i]) > maximum){
        //             maximum =  prices[j] - prices[i];
        //         }
        //     }
        // }
        // return maximum;
        // }
        int maxProfit = 0;
        int start=0;
        int end=prices.length-1;
        while(start<end){
            int min_price = prices[start];
            int min_x = start;
            int max_price = prices[start];
            int max_y = start;
            for(int i=start+1;i<=end;i++){
                //查找最小值及位置
                if(prices[i] < min_price){
                    min_price = prices[i];
                    min_x = i;
                }
                //查找最大值及位置
                if(prices[i] > max_price){
                    max_price = prices[i];
                    max_y = i;
                }
            }
            //System.out.println("min_price="+min_price);
            //System.out.println("max_price="+max_price);
            if(min_x < max_y){
                if(maxProfit < (max_price - min_price)){
                    maxProfit = max_price - min_price;
                }
                break;
            }
            //start到最大值之间
            int min_start_max_y=max_price;
            for(int i=start;i<max_y;i++){
                if(prices[i] < min_start_max_y){
                    min_start_max_y = prices[i];
                    //System.out.println(min_start_max_y);
                }
            }
            if((max_price - min_start_max_y) > maxProfit){
                maxProfit = max_price - min_start_max_y;
            }
            //最小值到end之间
            int max_min_x_end=min_price;
            // System.out.println("max_min_x_end="+max_min_x_end);
            for(int i=min_x+1;i<=end;i++){
                if((prices[i] > max_min_x_end)){
                    max_min_x_end = prices[i];
                    //System.out.println("@max_min_x_end="+max_min_x_end);
                }
            }
            if((max_min_x_end - min_price) > maxProfit){
                maxProfit = max_min_x_end - min_price;
            }
            //向中间逼近
            start = max_y + 1;
            end = min_x - 1;
            
        }
        return maxProfit;
    }
}
public class Solution {
    public int[] plusOne(int[] digits){
        int carry = 1;
        int temp;
        for(int i = digits.length-1;i>=0;i--){
            temp = digits[i];
            digits[i] = (temp +carry) % 10;
            carry = (temp +carry) / 10;
            if(carry == 0){
                break;
            }
        }
        if(carry == 1){
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        }else{
            return digits;
        }
    }
}
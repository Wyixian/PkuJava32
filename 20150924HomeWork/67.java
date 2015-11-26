public class Solution {
    public String addBinary(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		if(aLen > bLen) {
			int gap = aLen - bLen;
			while(gap-- > 0) b = 0 + b;
		}
		if(bLen > aLen) {
			int gap = bLen - aLen;
			while(gap-- > 0) a = 0 + a;
		}
		int maxLen = aLen > bLen ? aLen : bLen;
		int c = 0, sum = 0;
		String result = "";
		for(int i = --maxLen; i >= 0; i--) {
			sum = a.charAt(i) + b.charAt(i) + c - '0' * 2;
			if(sum > 1) {
				c = 1;
				sum -= 2;
			} else {
				c = 0;
			}
			result = sum + result;
		}
		if(c == 1) result = 1 + result;
		return result;
	}
}
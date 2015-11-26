public class Solution {
    public boolean isPowerOfTwo(int n) {
		int t;
		if(n == 0) 
		    return false;
		while((t=n%2) == 0) {
			n = n / 2;
		}
		if(t==1 && n==1)
			return true;
		return false;
	}
}
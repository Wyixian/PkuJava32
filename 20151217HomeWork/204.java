public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 1;
        for(int i=3; i<n; i+=2) {
            if(isPrime(i)) count++;
        }
        return count;
    }
    public boolean isPrime(int x) {
        int j = (int)Math.sqrt(x);
        for(int i=3; i<=j; i+=2) {
            if(x%i == 0)
                return false;
        }
        return true;
    }
}
public class Solution {
	//问题实际上是将一个26进制的数，转换成10进制的数
    public int titleToNumber(String s) {
        if(s==null || s.length() == 0){
            throw new IllegalArgumentException("Input is Wrong!");
        }
 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char c = 'A';
		for(int i=1; i<=26; i++){
			map.put(c, i);
			c += 1; 
		}
 
		int result = 0;
		int i = s.length()-1;
		int t = 0;
		while(i >= 0){
			char curr = s.charAt(i);
			result = result + (int) Math.pow(26, t) * map.get(curr);
			t++;
			i--;
		}
 
		return result;
    }
}
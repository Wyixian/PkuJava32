public class Solution 
{
    public int lengthOfLastWord(String s) 
    {
        //考虑到这个字符串结尾有空格的情况，所以从后面开始遍历，找到最后一个单词的最后一个字符开始计数，然后依次向前直到遇到第一个空格
        int length = 0;
		char[] chars = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--) 
		{
			if (length == 0) 
			{
				if (chars[i] == ' ') 
				{
					continue;
				} else 
				{
					length++;
				}
			} else 
			{
				if (s.charAt(i) == ' ') 
				{
					break;
				} else 
				{
					length++;
				}
			}
		}
		return length;
    } 
}
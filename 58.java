public class Solution 
{
    public int lengthOfLastWord(String s) 
    {
        //���ǵ�����ַ�����β�пո����������ԴӺ��濪ʼ�������ҵ����һ�����ʵ����һ���ַ���ʼ������Ȼ��������ǰֱ��������һ���ո�
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
public class Solution 
{  
    public void sortColors(int[] A) 
    {  
        //分别统计出现0、1、2出现的次数，然后直接给数组赋值
        int count0 = 0;  
        int count1 = 0;  
        int count2 = 0;  
        for(int i = 0; i < A.length; i++)
        {  
            if(A[i] == 0)
            {  
                count0++;  
            }  
            if(A[i] == 1)
            {  
                count1++;  
            }  
            if(A[i] == 2)
            {  
                count2++;  
            }  
        }  
        for(int i = 0; i < count0; i++)
        {  
            A[i] = 0;
        }  
        for(int i = count0; i < count0+count1; i++)
        {  
            A[i] = 1;  
        }  
        for(int i = count0+count1; i < count0+count1+count2; i++)
        {  
            A[i] = 2;  
        }  
    }  
}  
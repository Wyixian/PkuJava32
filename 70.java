public class Solution 
{
    public int climbStairs(int n) 
    {
        /*试想到达最后一个阶梯n的情况有两种，一种是从阶梯n-1爬一步到达，另一种是从阶梯n-2爬两步到达。
        然后对这两种情况分别用同样的思想，一直递归到最后只剩下1个或2个阶梯时，前者只有一种爬法，后者有两种爬法。
        显然，这道题可以用递归的思想解答：
        
        if(n == 1)
        return 1;
        else if(n == 2)
        return 2;
        else return climbStairs(n - 1) + climbStairs(n - 2);
        
        以上算法当n=44时，由于递归的层数太多，需要的内存指数级递增，出现了time limit exceeded，无法AC*/
        
        //上网查到这个问题符合斐波纳契数列：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
        //在数学上，斐波纳契数列以如下被以递归的方法定义：F（0）=0，F（1）=1，F（n）=F(n-1)+F(n-2)（n≥2，n∈N*）
        //可以看出斐波纳契数列第3项开始的每一项的大小依次是阶梯n=1,2,3,...的爬法数量，于是有：
        int a = 0;
        int b = 1;
        int sum = 0;
        for(int i = 1;i <= n;i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
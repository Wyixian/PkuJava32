class MinStack 
{
    Node top = null;
    
    public void push(int x)
    {
        if(top == null)
        {
            //若栈为空，则栈顶为x且最小值为x
            top = new Node(x);
            top.min = x;
        }else
        {
            //若栈顶非空，push x后令其为栈顶，并比较得到新的最小值
            Node temp = new Node(x);
            temp.next = top;
            top = temp;
            top.min = Math.min(top.next.min,x);
        }
    }

    public void pop() 
    {
        //移除栈顶元素，令栈顶元素为下一个元素
        top = top.next;
        return;
    }

    public int top() 
    {
        //判断栈是否为空，为空则输出0，非空则输出栈顶元素
        return top == null? 0 : top.val;    
    }

    public int getMin() 
    {
        return top == null? 0 : top.min;    
    }
}

//定义Node类
class Node
{
    int val;
    int min;
    Node next;
    
    public Node(int val)
    {
        this.val = val;
    }
}
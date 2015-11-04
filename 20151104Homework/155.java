class MinStack 
{
    Node top = null;
    
    public void push(int x)
    {
        if(top == null)
        {
            //��ջΪ�գ���ջ��Ϊx����СֵΪx
            top = new Node(x);
            top.min = x;
        }else
        {
            //��ջ���ǿգ�push x������Ϊջ�������Ƚϵõ��µ���Сֵ
            Node temp = new Node(x);
            temp.next = top;
            top = temp;
            top.min = Math.min(top.next.min,x);
        }
    }

    public void pop() 
    {
        //�Ƴ�ջ��Ԫ�أ���ջ��Ԫ��Ϊ��һ��Ԫ��
        top = top.next;
        return;
    }

    public int top() 
    {
        //�ж�ջ�Ƿ�Ϊ�գ�Ϊ�������0���ǿ������ջ��Ԫ��
        return top == null? 0 : top.val;    
    }

    public int getMin() 
    {
        return top == null? 0 : top.min;    
    }
}

//����Node��
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
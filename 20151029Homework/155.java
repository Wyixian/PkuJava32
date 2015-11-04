class MinStack {
    Node top = null;
    public void push(int x) {
        if (top == null) {
            top = new Node(x);
            top.min = x;
        } else {
            Node tmp = new Node(x);
            tmp.pre = top;
            top = tmp;
            if (top.pre.min > x)
                top.min = x;
            else
                top.min = top.pre.min;
        }
    }
    public void pop() {
        top = top.pre;
    }
    public int top() {
        return top.val;
    }
    public int getMin() {
        return top.min;
    }
}

class Node {
    int val;
    int min;
    Node pre;
    public Node(int val) {
        this.val = val;
    }
}
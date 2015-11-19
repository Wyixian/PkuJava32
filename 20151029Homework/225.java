class MyStack {
	Queue<Integer> q1 = new LinkedList<Integer>();
	//Push element x onto stack.
	public void push(int x) {
		q1.offer(x);
	}
	//Removes the element on the top of the stack.
	public void pop() {
		for(int i = 0; i < q1.size() - 1; i++)
				q1.offer(q1.poll());
		q1.remove();
	}
	//Get the top element.
	public int top() {
		for(int i = 0; i < q1.size() - 1; i++)
			q1.offer(q1.poll());
		int a = q1.poll();
		q1.offer(a);
		return a;
	}
	//public boolean empty() {
	public boolean empty() {
		return q1.size() == 0;
	}
}
public class MyQueue <T> {
    private MyLinkedList<T> queue;
    public MyQueue() {
        queue = new MyLinkedList<T>();
    }
    public void enqueue(T item) {
	queue.add(item);
    }
    public T dequeue() {
	if(queue.size() == 0) {
	    throw new NoSuchElementException();
	}
	return queue.remove(0);
    }
    public T peek() {
	if(queue.size() == 0) {
	    throw new NoSuchElementException();
	}
	return queue.get(0);
    }
    public int size() {
	return queue.size();
    }
    public boolean isEmpty() {
	return (queue.size() == 0);
    }
}

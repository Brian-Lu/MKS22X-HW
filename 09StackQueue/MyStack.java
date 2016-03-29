import java.util.*;
public class MyStack <T> {
    private MyLinkedList<T> stack;
    public MyStack() {
	stack = new MyLinkedList<T>();
    }
    public void push(T item) {
	stack.add(0, item);
    }
    public T pop() {
	if(size() == 0) {
	    throw new NoSuchElementException();
	}
	return stack.remove(0);
    }
    public T peek() {
	if(size() == 0) {
	    throw new NoSuchElementException();
	}
	return stack.get(0);
    }
    public int size() {
	return stack.size();
    }
    public boolean isEmpty() {
	return (size() == 0);
    }
}

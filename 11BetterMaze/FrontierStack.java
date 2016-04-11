import java.util.*;
public class FrontierStack<T> implements Frontier<T> {
    private Stack<T> stack;
    public FrontierStack() {
	stack = new Stack<T>();
    }
    public T next() {
	if(!hasNext()) {
	    throw new NoSuchElementException();
	}
	else{
	    return stack.pop();
	}
    }
    public void add(T element) {
	stack.push(element);
    }
    public boolean hasNext() {
	if(stack.isEmpty) {
	    return false;
	}
	else{
	    return true;
	}
    }
}

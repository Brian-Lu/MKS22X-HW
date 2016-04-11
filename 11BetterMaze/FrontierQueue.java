import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    private ArrayDeque<T> queue;
    public FrontierQueue() {
	queue = new ArrayDeque<T>();
    }
    public T next() {
	if(!hasNext()) {
	    throw new NoSuchElementException();
	}
	else{
	    return queue.removeFirst();
	}
    }
    public void add(T element) {
	queue.addLast(element);
    }
    public boolean hasNext() {
	if(queue.isEmpty()) {
	    return false;
	}
	else{
	    return true;
	}
    }
}

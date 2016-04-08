import java.util.*;
public class MyDeque<T>{
    private T[] data;
    private int size;
    private int start;
    private int end;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (T[]) new Object[10];
	size = 0;
	start = 0;
	end = 0;
    }
    @SuppressWarnings("unchecked")
    private void grow() {
	T[] temp = (T[]) new Object[data.length * 2];
	int a;
	a = 0;
	int i;
	i = start;
	while(a + 1 <= size) {
	    temp[a] = data[i];
	    if(i + 1 <= data.length - 1) {
		i++;
	    }
	    else{
		i = 0;
	    }
	    a++;
	}
	start = 0;
	end = size - 1;
	data = temp;
    }
    public void addFirst(T value) {
	if(size == data.length - 1) {
	    grow();
	}
	if(start >= 1) {
	    start --;
	}
        else if(start == 0) {
	    start = data.length - 1;
	}
	size++;
	data[start] = value;
    }
    public void addLast(T value) {
	if(size == data.length - 1) {
	    grow();
	}
	if(end < data.length - 1) {
	    end++;
	}
	else if(end == data.length - 1) {
	    end = 0;
	}
	size++;
	data[end] = value;
    }
    public T removeFirst() {
	if(size < 1) {
	    throw new NoSuchElementException();
	}
	T ret = data[start];
	data[start] = null;
	if(start + 1 == data.length) {
	    start = 0;
	}
	else{
	    start++;
	}
	size--;
	return ret;
    }
    public T removeLast() {
	if(size < 1) {
	    throw new NoSuchElementException();
	}
	T ret = data[end];
	data[end] = null;
	if(end > 0) {
	    end--;
	    size--;
	    return ret;
	}
	else{
	    end = data.length - 1;
	    size--;
	    return ret;
	}
    }
    public T getFirst() {
	if(size < 1) {
	    throw new NoSuchElementException();
	}
	return data[start];
    }
    public T getLast() {
	if(size < 1) {
	    throw new NoSuchElementException();
	}
	return data[end];
    }
    public boolean isEmpty() {
	return size == 0;
    }
    public int size() {
	return size;
    }
}

    

import java.util.*;
public class MyDeque<T>{
    private T[] data;
    private int size;
    private int start;
    private int end;
    public MyDeque() {
	data = (T[]) new Object[10];
	size = 0;
	start = 0;
	end = 0;
    }
    private void grow() {
	T[] temp = (T[]) new Object[data.length * 2];
	int i = 0;
	while(i < data.length) {
	    temp[i] = data[i];
	}
	data = temp;
    }
    public void addFirst(T value) {
	if(size == data.length) {
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
	if(size == data.length) {
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
	if(start < data.length - 1) {
	    start++;
	    size--;
	    return data[start - 1];
	}
	else{ 
	    start = 0;
	    size--;
	    return data[data.length - 1];
	}
    }
    public T removeLast() {
	if(size < 1) {
	    throw new NoSuchElementException();
	}
	if(end > 0) {
	    end--;
	    size--;
	    return data[end + 1];
	}
	else{
	    end = data.length - 1;
	    size--;
	    return data[0];
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
}
    

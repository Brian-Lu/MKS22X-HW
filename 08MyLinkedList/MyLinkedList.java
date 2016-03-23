public class MyLinkedList <T>{
    private class LNode {
	public LNode next;
	public T value;
	public LNode(T data) {
	    value = data;
	}
	public T getValue() {
	    return value;
	}
	public LNode getNext() {
	    return next;
	}
	public void setValue(T data) {
	    value = data;
	}
	public void setNext(LNode data) {
	    next = data;
	}
    }
    private LNode head;
    private LNode last;
    private int size;
    public int size() {
	return size;
    }
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public T get(int index) {
	if(index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int i = 0;
	while(i < index) {
	    current = current.getNext();
	    i++;
	}
	return current.getValue();
    }
    public T set(int index,T newValue) {
	if(index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int i = 0;
	while(i < index) {
	    current = current.getNext();
	    i++;
	}
	T ret = current.getValue();
	current.setValue(newValue);
	return ret;
    }
    
    public T remove(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	T ret;
	if (index == 0) {
	    ret = head.getValue();
	    head = head.getNext();
	} else {
	    LNode current = head;
	    int i = 0;
	    while (i + 1 < index) {
		current = current.getNext();
		i++;
	    }
	    if (index == size - 1) {
		last = current;
	    }
	    ret = current.getNext().getValue();
	    current.setNext(current.getNext().getNext());
	}
	size--;
	return ret;
    }

    public boolean add(int index, T value) {
	if(index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = new LNode(value);
	if(index == 0 || head == null) {
	    temp.setNext(head);
	    head = temp;
	}
	if(index == size()) {
	    return add(value);
	}
	else{
	    LNode current = head;
	    int i = 0;
	    while(i + 1 < index) {
		current = current.getNext();
		i++;
	    }
	    temp.setNext(current.getNext());
	    current.setNext(temp);
	}
	size += 1;
	return true;
    }
    public boolean add(T value) {
	if(head == null) {
	    head = new LNode(value);
	    last = head;
	}
	else {
	    last.setNext(new LNode(value));
	    last = last.getNext();
	}
	size += 1;
	return true;
    }
    public int indexOf(T value) {
	LNode current = head;
	int i = 0;
	while(current != null) {
	    if(current.getValue().equals(value)) {
		return i;
	    }
	    current = current.getNext();
	    i++;
	}
	return -1;
    } 
}
  
	    

	    

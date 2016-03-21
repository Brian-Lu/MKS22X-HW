public class MyLinkedList{
    private class LNode {
	public LNode next;
	public int value;
	public LNode(int data) {
	    value = data;
	}
	public int getValue() {
	    return value;
	}
	public LNode getNext() {
	    return next;
	}
	public void setValue(int data) {
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
    public int get(int index) {
	LNode current = head;
	int i = 0;
	while(i < index) {
	    current = current.getNext();
	    i++;
	}
	return current.getValue();
    }
    public int set(int index, int newValue) {
	LNode current = head;
	int i = 0;
	while(i < index) {
	    current = current.getNext();
	    i++;
	}
	int ret = current.getValue();
	current.setValue(newValue);
	return ret;
    }
    public int remove (int index) {
	if(index < 0 || index >= size) {
	    return -1;
	}
	if(index == 0) {
	    int ret = head.getValue();
	    head = head.getNext();
	    return ret;
	}
	else{
	    LNode current = head;
	    LNode holder = null;
	    int i = 0;
	    while(i != index) {
		if(i == index - 1) {
		    holder = current;
		}
		current = current.getNext();
		i++;
	    }
	    int ret = current.getValue();
	    holder.setNext(current.getNext());
	    return ret;
	}
    }
    public boolean add(int index, int value) {
	if(index < 0 || index > size) {
	    return false;
	}
	LNode temp = new LNode(value);
	if(index == 0 || head == null) {
	    temp.setNext(head);
	    head = temp;
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
    public boolean add(int value) {
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
    public int indexOf(int value) {
	LNode current = head;
	int i = 0;
	while(current != null) {
	    if(current.getValue() == value) {
		return i;
	    }
	    current = current.getNext();
	    i++;
	}
	return -1;
    }
}
	    

	    

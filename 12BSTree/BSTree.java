public class BSTree<T extends Comparable<T>>{
    private class Node{
	private T data;
	private Node left;
	private Node right;
	public Node(T Data) {
	    setData(Data);
	}
	public Node(T Data, Node Left, Node Right) {
	    setData(Data);
	    setLeft(Left);
	    setRight(Right);
	}
	private void setData(T n) {
	    data = n;
	}
	private void setLeft(Node n) {
	    left = n;
	}
	private void setRight(Node n) {
	    right = n;
	}
	private T getData() {
	    return data;
	}
	private Node getLeft() {
	    return left;
	}
	private Node getRight() {
	    return right;
	}
	private int height() {
	    if(getLeft() == null && getRight() == null) {
		return 1;
	    }
	    if(getLeft() == null) {
		return 1 + getRight().height();
	    }
	    if(getRight() == null) {
		return 1 + getLeft().height();
	    }
	    else{
		return 1 + Math.max(getLeft().height() , getRight().height());
	    }
	}
	private void add(T value) {
	    if(data == null) {
		data = value;
	    }
	    else if(value.compareTo(getData()) > 0) {
		if(getRight() != null) {
		    getRight().add(value);
		}
		else{
		    setRight(new Node(value));
		}
	    }
	    else{
		if(getLeft() != null) {
		    getLeft().add(value);
		}
		else{
		    setLeft(new Node(value));
		}
	    }
	}
	public String toString(){
	    String ret = "" +  getData() + " ";
	    if(getLeft() != null){
		ret += getLeft().toString();
	    }else{
		ret += "_ ";
	    }
	    if(getRight()!=null){
		ret += getRight().toString();
	    }else{
		ret += "_ ";
	    }
	    return ret;
	}
	private T remove(T value) {
	    if(value.compareTo(data) > 0) {
		T tempValue = right.remove(value);
		if(right.getData() == null) {
		    right = null;
		}
		return tempValue;
	    }
	    else if(value.compareTo(data) < 0) {
		T tempValue = left.remove(value);
		if(right.getData() == null) {
		    left = null;
		}
		return tempValue;
	    }
	    else{
		T tempValue = getData();
		if (left!= null && right == null) {
		    setData(getLeft().getData());
		    setRight(getLeft().getRight());
		    setLeft(getLeft().getLeft());
		}
		else if (left == null && right != null) {
		    setData(getRight().getData());
		    setLeft(getRight().getLeft());
		    setRight(getRight().getRight());
		}
		else if(left != null && right != null) {
		    Node i = left;
		    while(i.right != null) {
			i = i.right;
		    }
		    setData(remove(i.getData()));
		}
		else{
		    data = null;
		}
		return tempValue;
	    }
	}
	private boolean contains(T value) {
	    if(getData().equals(value)) {
		return getData().equals(value);
	    }
	    if(getLeft() == null && getRight() != null) {
		return getRight().contains(value);
	    }
	    if(getLeft() != null && getRight() == null) {
		return getLeft().contains(value);
	    }
	    if(getLeft() == null && getRight() == null) {
		return false;
	    }
	    else if(getLeft() != null && getRight() != null) {
		return getLeft().contains(value) || getRight().contains(value);
	    }
	    else{
		return false;
	    }
	}
    }
    private Node root;
    public int getHeight() {
	if(root == null) {
	    return 0;
	}
	return root.height();
	
    }
    public void add(T value) {
	if(root == null) {
	    root = new Node(value);
	}
	root.add(value);
    }
    public String toString() {
	if(root == null) {
	    return " ";
	}
	return root.toString();
    }
    public boolean contains(T value) {
	if(root == null) {
	    return false;
	}
	return root.contains(value);
    }
    public T remove(T value) {
	if(root == null) {
	    return null;
	}
	return root.remove(value);
    }
}
			    
		
	    

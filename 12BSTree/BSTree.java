import java.util.*;
public class BSTree<T extends Comparable<T>>{
    private class Node{
	public T data;
	public Node left;
	public Node right;
	public Node(T Data) {
	    data = Data;
	}
	public Node(T Data, Node Left, Node Right) {
	    setData(Data);
	    setLeft(Left);
	    setRight(Right);
	}
	public void setData(T n) {
	    data = n;
	}
	public void setLeft(Node n) {
	    left = n;
	}
	public void setRight(Node n) {
	    right = n;
	}
	public T getData() {
	    return data;
	}
	public Node getLeft() {
	    return left;
	}
	public Node getRight() {
	    return right;
	}
	public int height() {
	    if(left == null && right == null) {
		return 1;
	    }
	    if(left == null) {
		return 1 + right.height();
	    }
	    if(right == null) {
		return 1 + left.height();
	    }
	    else{
		return 1 + Math.max(left.height() , right.height());
	    }
	}
	private void add(T value) {
	    if(data.compareTo(value) < 0) {
		if(right != null) {
		    right.add(value);
		}
		else if(right == null) {
		    right = new Node(value);
		}
	    }
	    else if(data.compareTo(value) > 0) {
		if(left != null) {
		    left.add(value);
		}
		else if(left == null) {
		    left = new Node(value);
		}
	    }
	}
	public String toString(){
	    if(left == null && right == null){
		return data + " _ _";
	    }else if(left == null){
		return data + " _ " + right.toString();
	    }else if(right == null){
		return data + " " + left.toString() + " _";
	    }else{
		return data + " " + left.toString() + " " + right.toString();
	    }
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
	    if(data.compareTo(value) == 0) {
		return true;
	    }
	    if(value.compareTo(data) < 0) {
		if(left != null) {
		    return left.contains(value);
		}
		else{
		    return false;
		}
	    }
	    if(value.compareTo(data) > 0) {
		if(right != null) {
		    return right.contains(value);
		}
		else{
		    return false;
		}
	    }
	    return false;
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
	else{
	root.add(value);
	} 
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

    public static void main(String[] args) {
	BSTree<Integer> test = new BSTree<Integer>();
	test.add(10);
	test.add(9);
	test.add(11);
	test.add(16);
	test.add(8);
	System.out.println(test);
	System.out.println(test.getHeight());
	System.out.println(test.contains(10));
	System.out.println(test.contains(16));
	System.out.println(test.contains(8));
	System.out.println(test.contains(0));	
    }
}
			    
		
	    

import java.util.*;
@SuppressWarnings("unchecked")
public class RunningMedian {
    public MyHeap<Integer> SmallNum;
    public MyHeap<Integer> BigNum;
    public RunningMedian() {
	SmallNum = new MyHeap(true);
	BigNum = new MyHeap(false);
    }
    public double getMedian() {
	if(SmallNum.size() == 0 && BigNum.size() == 0) {
	    throw new NoSuchElementException();
	}
	else if(SmallNum.size() == BigNum.size()) {
	    return( (SmallNum.peek() + BigNum.peek()) / 2.0);
	}
	else if(SmallNum.size() > BigNum.size()) {
	    return SmallNum.peek();
	}
	else if(SmallNum.size() < BigNum.size()) {
	    return BigNum.peek();
	}
	else {
	    return ( (SmallNum.peek() + BigNum.peek()) / 2.0);
	}
    }
    public void add(Integer x) {
	if( SmallNum.size() == 0) {
	    SmallNum.add(x);
	}
	else if(BigNum.size() == 0 && SmallNum.size() > 0) {
	    BigNum.add(x);
	}
	else {
	    if(x > getMedian()) {
		BigNum.add(x);
	    }
	    else {
		SmallNum.add(x);
	    }
	}
	while((Math.abs(SmallNum.size() - BigNum.size())) > 1) {
	    if(BigNum.size() - 1 > SmallNum.size()) {
		SmallNum.add(BigNum.delete());
	    }
	    if(BigNum.size() < SmallNum.size() - 1) {
		BigNum.add(SmallNum.delete());
	    }
	}
    }
    public String toString() {
	return SmallNum.toString() + "\n" + BigNum.toString() + "\n" + "median: " + getMedian();
    }
    public static void main(String args[]){
	RunningMedian test = new RunningMedian();
	test.add(5);
	System.out.println(test);
	test.add(10);
	test.add(2);
	test.add(19);
	test.add(-4);
	test.add(0);
	test.add(11);
	test.add(13);
	test.add(24);
	test.add(50);
	test.add(32);
	test.add(49);
	System.out.println(test);
    }
}
	   

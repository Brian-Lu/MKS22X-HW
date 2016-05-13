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
	else if(BigNum.size() == 0) {
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
}
	   

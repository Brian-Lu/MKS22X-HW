public class RunningMedian {
    MyHeap<Integer> SmallNum;
    MyHeap<Integer> BigNum;
    public RunningMedian() {
	SmallNum = new MyHeap(true);
	BigNum = new MyHeap(false);
    }
    public double getMedian() {
	if(SmallNum.

import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
   private int size;
   private T[] data;
   private boolean isMax;
   public MyHeap(){
       data = (T[]) new Comparable[4];
       isMax = true;
   }
   public MyHeap(T[] array) {
       size = array.length;
       data = (T[]) new Comparable[size + 1];
       isMax = true;
       for(int i = 0; i < size; i++) {
	   data[i + 1] = array[i];
       }
       heapify();
   }

       
   /**pushDown
      precondition: datas[k]'s children are valid heaps
      postconditions:-the element at index k has been 
                     shifted to the correct spot.
                     -data[k] and is a valid heap
   **/
   private void pushDown(int k) {
       if( (k - 1) * 2 < size ) {
	   int doubleK = k * 2;
	   if(isMax) {
	       if(data[k].compareTo(data[doubleK]) < 0 || data[k].compareTo(data[doubleK + 1]) < 0){
		   if(data[doubleK].compareTo(data[doubleK + 1]) > 0){
		       swap(k, doubleK);
		       pushDown(doubleK);
		   }
		   else{
		       swap(k, doubleK + 1);
		       pushDown(doubleK + 1);
		   }
	       }
	   }
	   else{
	       if(data[k].compareTo(data[doubleK]) > 0 || data[k].compareTo(data[doubleK + 1]) > 0){
		   if(data[doubleK].compareTo(data[doubleK + 1]) < 0){
		       swap(k,doubleK);
		       pushDown(doubleK);
		   }
		   else{
		       swap(k, doubleK + 1);
		       pushDown(doubleK + 1);
		   }
	       }
	   }
       }
   }
   
   /**pushUp
      precondition: data is a heap with at most one item
      out of place (element at k)
      postconditions:-the element at index k has been 
      shifted to the correct spot.
      -data is a valid heap
   **/
   private void pushUp(int k) {
       if(k > 1) {
	   if(isMax) {
	       if(data[k].compareTo(data[k / 2]) > 0) {
		   swap(k, k / 2);
		   k /= 2;
		   pushUp(k);
	       }
	   }
	   else{
	       if(data[k].compareTo(data[k / 2]) < 0) {
		   swap(k, k / 2);
		   k /= 2;
		   pushUp(k);
	       }
	   }
       }
   }
   private void heapify() {
       for(int i = size / 2; i > 0; i--) {
	   pushDown(i);
       }
   }
   public T delete() {
       if(size == 0) {
	   throw new NoSuchElementException();
       }
       if(size == 1) {
	   T ret = data[1];
	   data[1] = null;
	   size--;
	   return ret;
       }
       else{
	   T ret = data[1];
	   data[1] = data[size];
	   data[size] = null;
	   size--;
	   pushDown(1);
	   return ret;
       }
   }
   public void add(T x) {
       if(size == 0) {
	   data[1] = x;
	   size++;
       }
       else{
	   if(size + 2  > data.length) {
	       doubleSize();
	   }
	   data[size + 1] = x;
	   pushUp(size + 1);
	   size++;
       }
   }
   private void doubleSize() {
       T[] temp = (T[]) new Comparable[size * 2 + 1];
       for(int i = 0; i < data.length; i++) {
	   temp[i] = data[i];
       }
       data = temp;
   }
   public String toString() {
       String ret = "[";
       for(int i = 1; i < size; i++) {
	   ret += data[i] + ", ";
       }
       ret += data[size];
       ret += "]";
       return ret;
   }
   //do this last
   public MyHeap(boolean Max) {
       isMax = Max;
       data = (T[]) new Comparable[4];
   }
   public MyHeap(T[] array, boolean Max) {
       this(array);
       isMax = Max;
       heapify();
   }
   private void swap(int index1, int index2) {
       T holder = data[index1];
       data[index1] = data[index2];
       data[index2] = holder;
   }  
   public T peek() {
       if(size == 0) {
	   throw new NoSuchElementException();
       }
       else {
	   return data[1];
       }
   }
   public int getSize() {
       return size;
   }
}

public class MyLinkedList{
    private LNode start;
    private int size;
    public String toString() {
	String ret = "[";
	return toString(start, size, ret);
    }
    public String toString(LNode Start, int Size, String str) {
	str += Start.getValue;
	Size -= 1;
	return toString(Start, Size, str);
}

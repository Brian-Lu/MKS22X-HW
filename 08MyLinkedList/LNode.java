public class LNode{
    private int value;
    private LNode next;
    public LNode(int Value) {
	value = Value;
    }
    public LNode(int Value, LNode Next) {
	value = Value;
	next = Next;
    }
    public int getValue() {
	return value;
    }
    public LNode getLNode() {
	return LNode;
    }
    public int setValue(int Value) {
	int x = value;
	value = Value;
	return x;
    }
    public LnODE setLNode(LNode Next) {
	LNode x = next;
	next = Next;
	return x;
    }
}
	

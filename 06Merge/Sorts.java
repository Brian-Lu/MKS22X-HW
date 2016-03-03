public class Sorts{
    public int[] ary;
    public Sorts() {
	ary = new int[5];
    }
    public Sorts(int x){
	ary = new int[x];
    }
    public Sorts(int[] x) {
	for (int i = 0; i < x.length; i++) {
	    int y = 0;
	    y = x[i];
	    ary[i] = y;
	}
    }
    public static void mergeSort(int[] x) {
    }
}

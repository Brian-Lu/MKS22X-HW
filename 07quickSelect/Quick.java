import java.util.Arrays;
public class Quick{
    public static String name() {
        return "7,Lu,Brian";
    }
    private static int partitionOld(int[]data, int left, int right) {
        int element = (int)((Math.random() * (right - left + 1)) + left);
        int pElement = data[element];
        int counter = 0;
        for(int i = left; i <= right; i++) {
            if (data[i] < pElement){
                    counter++;
                }
        }
        data[element] = data[right];
        data[right] = pElement;
        int[] ary = new int[right - left + 1];
        int a = left;
        int x = 0;
        while(x < counter) {
            if(data[a] < pElement) {
                ary[x] = data[a];
                x++;
            }
            a++;
        }
        ary[x] = pElement;
        x++;
        for(int i = left; i <= right - 1; i++) {
            if(data[i] >= pElement) {
                ary[x] = data[i];
                x++;
            }
        }
        for(int i = 0; i < right - left + 1; i++) {
            data[left + i] = ary[i];
        }
        return left + counter;
    }
    public static void quickSortOld(int[] data) {
        quickSortOld(data, 0, data.length - 1);
    }
    public static void quickSortOld(int[] data, int left, int right) {
        if(right - left > 0) {
            int x = partitionOld(data, left, right);
            quickSortOld(data,left, x - 1);
            quickSortOld(data,x+1, right);
        }
    }
    public static int quickselectOld(int[] data, int k) {
        return quickselectHOld(data,k,0,data.length-1);
    }
    public static int quickselectHOld(int[] data,int k, int left, int right) {
        if(left == right) {
            return data[left];
        }
        int x = partitionOld(data, left, right);
        if(x == k) {
            return data[x];
        }
        if(k > x) {
            return quickselectHOld(data, k, x+1, right);
        }
        else {
            return quickselectHOld(data, k, left, x-1);
        }
    }
    public static int[] partition(int[] data, int left, int right) {
	int [] ret = int[2];
	int element = (int)((Math.random() * (right - left)) + right);
	int pElement = data[element];
	int repeats = 0;
	int lessThan = 0;
	for (int i = 0; i < data.length; i++) {
	    if(data[i] == pElement){
		repeats++;
	    }
	    if(data[i] < pElement) {
		lessThan++;
	    }
	}
	int greaterThan = (data.length - repeats) - lessThan;
	return ret;
    }
    public static void main(String[]args) {
	int[] d = new int[4000000];
	int[] c = new int[d.length];
	for(int i = 0; i < d.length; i++) {
	    d[i] = (int)(Math.random() * Integer.MAX_VALUE);
	    c[i] = d[i];
	}
        quickSortOld(d);
	Arrays.sort(c);
	System.out.println(Arrays.equals(d,c));
    }
	
}

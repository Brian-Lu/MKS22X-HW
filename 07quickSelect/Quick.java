public class Quick{
    public static String name() {
	return "7,Lu,Brian";
    }
    private static int partition(int[]data, int left, int right) {
	int element = (int)((Math.random() * (right - left)) + left);
	int pElement = data[element];
	int counter = 0;
	for(int i = left; i <= right; i++) {
	    if data[i] < pElement{
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
    public static int quickselect(int[] data, int k) {
	quickselectH(data,k,0,data.length-1);
    }
    public static int quickselectH(int[] data,int k, int left, int right) {
	int x = partition(data, 0, data.length);
	if(x == k) {
	    return data[x];
	}
	if(k > x) {
	    quickselectH(data, k, x+1, right);
	}
	else {
	    quickselectH(data, k, left, x-1);
	}
    }
}

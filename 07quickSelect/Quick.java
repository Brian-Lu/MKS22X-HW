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
    private static void quickSortOld(int[] data, int left, int right) {
        if(right - left > 0) {
            int x = partitionOld(data, left, right);
            quickSortOld(data,left, x - 1);
            quickSortOld(data,x + 1, right);
        }
    }
    public static int quickselectOld(int[] data, int k) {
        return quickselectHOld(data,k,0,data.length-1);
    }
    private static int quickselectHOld(int[] data,int k, int left, int right) {
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
    private static int[] partition(int[] data, int left, int right) {
        int[] ret = new int[2];
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
        int repeats = 0;
        for(int i = left; i <= right - 1; i++) {
            if(data[i] == pElement) {
                ary[x] = data[i];
                x++;
                repeats++;
            }
        }
        for(int i = left; i <= right - 1; i++) {
            if(data[i] > pElement) {
                ary[x] = data[i];
                x++;
            }
        }
        for(int i = 0; i < right - left + 1; i++) {
            data[left + i] = ary[i];
        }
        ret[0] = left + counter;
        ret[1] = left + counter + repeats;
        return ret;
    }
    private static void quickSort(int[] data, int left, int right) {
        if(right - left > 0) {
            int[] index = partition(data, left, right);
            quickSort(data,left, index[0] - 1);
            quickSort(data, index[1] + 1, right);
        }
    }
    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }
    public static void main(String[]args) {
        int[] d = new int[4000000];
        int[] a = new int[4000000];
        int[] c = new int[4000000];
        for(int i = 0; i < d.length; i++) {
            d[i] = (int)(Math.random() * Integer.MAX_VALUE);
            c[i] = d[i];
            a[i] = d[i];
        }
        Arrays.sort(c);
        quickSortOld(a);
        quickSort(d);
        System.out.println(Arrays.equals(c,d) && Arrays.equals(c, a));
    }
}

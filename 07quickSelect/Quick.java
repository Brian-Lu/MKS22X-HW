public class Quick{
    public static String name() {
        return "7,Lu,Brian";
    }
    private static int partition(int[]data, int left, int right) {
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
    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }
    public static void quickSort(int[] data, int left, int right) {
        if(right - left > 0) {
            int x = partition(data, left, right);
            quickSort(data,left, x - 1);
            quickSort(data,x+1, right);
        }
    }
    public static int quickselect(int[] data, int k) {
        return quickselectH(data,k,0,data.length-1);
    }
    public static int quickselectH(int[] data,int k, int left, int right) {
        if(left == right) {
            return data[left];
        }
        int x = partition(data, left, right);
        if(x == k) {
            return data[x];
        }
        if(k > x) {
            return quickselectH(data, k, x+1, right);
        }
        else {
            return quickselectH(data, k, left, x-1);
        }
    }
    /*
    public static void main(String[]args){
        int[] a = {1 , 2, 5, 67 , 4, 3, -5, 12, 51, 516, 7, 12, 61, -15, -29, 15, 17, 122, -122, 122};
        quickSort(a);
        System.out.println(a.length);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    */
}

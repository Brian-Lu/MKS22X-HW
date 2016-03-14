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

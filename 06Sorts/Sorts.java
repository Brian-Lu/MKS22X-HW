public class Sorts{
    public static String name() {
	return "7,Lu,Brian";
    }
    public static int[] mergesort(int[] data){
	if(data.length == 1) {
	    return data;
	}
	int[] aryA = new int[(data.length / 2)];
	for(int i = 0; i < (data.length / 2); i++) {
	    aryA[i] = data[i];
	}
	int[] aryB;
	if(data.length % 2 == 1) {
	    aryB = new int[(data.length / 2) + 1];
	}
	else{
	    aryB = new int[data.length / 2];
	}
	for(int i = (data.length / 2); i < data.length; i++) {
	    aryB[i-(data.length / 2)] = data[i];
	}
	return merge(mergesort(aryA), mergesort(aryB));
    }
    public static int[] merge(int[] aryA, int[] aryB) {
	int counter1, counter2;
	counter1 = 0;
	counter2 = 0;
	int[] ret = new int[aryA.length + aryB.length];
	while(counter1 + counter2 < ret.length) {
	    if(aryA.length <= counter1) {
		ret[counter1 + counter2] = aryB[counter2];
		counter2++;
	    }
	    else if(aryB.length <= counter2) {
		ret[counter1 + counter2] = aryA[counter1];
		counter1++;
	    }
	    else{
		if(aryA[counter1] > aryB[counter2]) {
		    ret[counter1 + counter2] = aryB[counter2];
		    counter2++;
		}
		else{
		    ret[counter1 + counter2] = aryA[counter1];
		    counter1++;
		}
	    }
	}
	return ret;
    }	
}

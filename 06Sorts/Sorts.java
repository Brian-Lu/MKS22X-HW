public class Sorts{
    public static String name() {
	return "7,Lu,Brian";
    }
    public static void mergesort(int[] data) {
	int[] ary = new int[data.length];
	ary = mergesortH(data);
	for(int i = 0; i < data.length; i++) {
	    data[i] = ary[i];
	}
    }
    public static int[] mergesortH(int[] data){
	if(data.length == 1) {
	    return data;
	}
	int[] aryA = new int[(data.length / 2)];
	int[] aryB;
	for(int i = 0; i < (data.length / 2); i++) {
	    aryA[i] = data[i];
	}
	if(data.length % 2 == 1) {
	    aryB = new int[(data.length / 2) + 1];
	}
	else{
	    aryB = new int[data.length / 2];
	}
	for(int i = 0; i < data.length - (data.length / 2); i++) {
	    aryB[i] = data[i + data.length];
	}
	return merge(mergesortH(aryA), mergesortH(aryB));
    }
    public static int[] merge(int[] aryA, int[] aryB) {
	int counter1, counter2;
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

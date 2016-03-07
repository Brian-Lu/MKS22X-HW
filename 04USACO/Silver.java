import java.util.*;
import java.io.*;
public class Silver{
    public int[][] pasture;
    public int T;
    public int R2;
    public int C2;
    public Silver(String filename){
	try{
	    Scanner in = new Scanner(new File(filename));
	    Scanner s = new Scanner(in.nextLine());
	    int y = s.nextInt();
	    int z = s.nextInt();
	    T = s.nextInt();
	    int[][] ary = new int[y][z];
	    for(int i = 0; i < y; i++){
		String str = new String(in.nextLine());
		for(int a = 0; a < z; a++){
		    if(str.charAt(a) == '.'){
			ary[i][a] = 0;
		    }else{
			ary[i][a] = -1;
		    }
		}
	    }
	    Scanner a = new Scanner(in.nextLine());
	    ary[a.nextInt() - 1][a.nextInt() - 1] = 1;
	    pasture = ary;
	    R2 = (a.nextInt() - 1);
	    C2 = (a.nextInt() - 1);
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	}
    }
    public int[][] solve(){
	if(T == 0) {
	    System.out.println(pasture[R2][C2] + ",7,Lu,Brian");
	    return pasture;
	}
	int[][] ary = new int[pasture.length][pasture[0].length];
	for(int i = 0; i < pasture.length; i++){
	    for(int a = 0; a < pasture[i].length; a++){
		if(pasture[i][a] == -1){
		    ary[i][a] = -1;
		}else{
		    int x = 0;
		    if(i > 0 && pasture[i-1][a] != -1){
			x += pasture[i-1][a];
		    }
		    if(i < (pasture.length - 1) && pasture[i+1][a] != -1){
			x += pasture[i+1][a];
		    }
		    if(a > 0 && pasture[i][a - 1] != -1){
			x += pasture[i][a - 1];
		    }
		    if(a < (pasture[0].length - 1) && pasture[i][a + 1] != -1){
			x += pasture[i][a + 1];
		    }
		    ary[i][a] = x;
		}
	    }
	}
	pasture = ary;
	T--;
	return solve();	
    }
    public static void main(String[]args){
	Silver x = new Silver("ctravel.in");
	x.solve();
    }
}

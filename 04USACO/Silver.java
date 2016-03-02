import java.util.*;
import java.io.*;
public class Silver{
    public int R1;
    public int C1;
    public int R2;
    public int C2;
    public int T;
    public int[][] pasture;
    public Silver(String file){
	try{
	    Scanner in = new Scanner(new File(file));
	    T = 0;
	    int x = 1;
	    int y = 0;
	    int z = 0;
	    while(in.hasNext()){
		String line = in.nextLine();
		Scanner nextLine = new Scanner(line);
		if(x == 1){
		    y = nextLine.nextInt();
		    z = nextLine.nextInt();
		    T = nextLine.nextInt();
		    pasture = new int[y][z];
		}else if(x <= y + 1){
		    for(int i = 0;i < z;i++){
			if(line.charAt(i)=='.'){
			    pasture[x - 2][i]=0;
			}else if(line.charAt(i)=='*'){
			    pasture[x - 2][i]=-1;
			}
		    }
		}else{
		    R1 = line.nextInt();
		    C1 = line.nextInt();
		    R2 = line.nextInt();
		    C2 = line.nextInt();
		}
		x++;
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	}
    }
    public int solve(){
	for(int i = 0; i <= T;i++){
	    if(i == 0) {
		pasture[R1-1][C1-1] = 1;
	    }
	    else{
		solveH();
	    }
	}
	return pasture[R2-1][C2-1];
    }
    public void solveH(){
	int[][] ary = new int[pasture.length][pasture[0].length];
	int tot = 0;
	for(int i = 0; i < pasture.length;i++){
	    for(int a = 0;a < pasture[0].length;a++){
		tot = 0;
		if(a>0){
		    if(pasture[i][a - 1]>0){
			tot += pasture[i][a - 1];
		    }
		}
		if(i > 0){
		    if(pasture[i-1][a]>0){
			tot += pasture[i - 1][a];
		    }
		}
		if(i < (pasture.length - 1)){
		    if(pasture[i + 1][a]>0){
			tot += pasture[i + 1][a];
		    }
		}
		if(a < (pasture[0].length - 1)){
		    if(pasture[i][a + 1]>0){
			tot += pasture[i][a + 1];
		    }
		}
		if(pasture[i][a] != -1){
		    ary[i][a]=tot;
		}
	    }
	}
	pasture = ary;
    }
    public static void main(String[]args){
	Silver x = new Silver("pasture.in");
	System.out.println(x.solve() + ",7,Lu,Brian");
    }
}

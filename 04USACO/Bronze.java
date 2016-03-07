import java.util.*;
import java.io.*;
public class Bronze{
    public int E;
    public int[][] height;
    public int[][] instructions; 
    public Bronze(String filename){
	try{
	    Scanner s = new Scanner(new File(filename));
	    int row = s.nextInt();
	    int column = s.nextInt();
	    E = s.nextInt();
	    int N = s.nextInt();
	    height = new int[row][column];
	    s.nextLine();
	    for(int i = 0; i < row; i++){
		int a = 0;
		Scanner p = new Scanner(s.nextLine());
		while(p.hasNext()){
		    height[i][a] = p.nextInt();
		    a++;
		}
	    }
	    instructions = new int[N][3];
	    for(int i = 0; i < N; i++){
		Scanner a = new Scanner(s.nextLine());
		instructions[i][0] = a.nextInt();
		instructions[i][1] = a.nextInt();
		instructions[i][2] = a.nextInt();
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File Not Found");    
	}
    }
    public void stomp(int X, int Y, int deepness){
	int counter = height[X][Y];
	for(int r = X - 1; r < X + 2;r++){
	    for(int c = Y - 1; c < Y + 2;c++){
		if(height[r][c]> counter){
		    counter = height[r][c];
		}
	    }
	}
	for(int i = X - 1; i < X + 2; i++){
	    for(int a = Y - 1; a < Y + 2; a++){
		if(height[i][a] > counter - deepness){
		    height[i][a] = counter - deepness;
		}
	    }
	}
    }
    public void finder(){
	for(int i = 0; i < height.length; i++){
	    for(int a = 0; a < height[i].length; a++){
		if( height[i][a] >= E){
		    height[i][a]=0;
		}
		else {
		    height[i][a]= E - height[i][a];
		}
	    }
	}
    }
    public int depth(){
	int ret = 0;
	for(int i = 0; i < height.length; i++){
	    for(int a = 0; a < height[i].length; a++){
		ret += height[i][a];
	    }
	}
	return ret;
    }
    public int calculate(){
	int ret;
	for(int i = 0;i < instructions.length; i++){
	    stomp(instructions[i][0], instructions[i][1], instructions[i][2]);
	}
	finder();
	ret = depth();
	return (ret * 5184);
    }
    public static void main(String[]args){
	Bronze pasture = new Bronze("makelake.in");
	System.out.println(pasture.calculate() + ",7, Lu, Brian");
    }
}

import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	private int[] rowcol;
	private Node prev;
	public Node(int[] ary, Node node) {
	    prev = node;
	    rowcol = ary;
	}
	public Node getPrev() {
	    return prev;
	}
	public int[] getRC() {
	    return rowcol;
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
	return solution;
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
	int[] S = {startRow, startCol};
	Node start = new Node(S, null);
	placesToGo.add(start);
	Node current = start;
	int r = startRow;
	int c = startCol;
	while(maze[r][c] != 'E') {
	    if(animate) {
		System.out.println(this);
		wait(20);
	    }
	    if(maze[r][c] != 'S') {
		maze[r][c] = '.';
	    }
	    addHelper(S, current);
	    if( !(placesToGo.hasNext())) {
		return false;
	    }
	    else{
		current = placesToGo.next();
		S = current.getRC();
		r = S[0];
		c = S[1];
	    }
	}
	solution = S;
	return true;
    }    
    private void addHelper(int[] ary, Node node) {
	if ((ary[0] >= 0 && ary[0] < maze.length) && (ary[1] + 1 >= 0 && ary[1] + 1 < maze[1].length))
	    if(maze[ary[0]][ary[1] + 1] != '.' && maze[ary[0]][ary[1] + 1] != '#') {
		int[] temp = {ary[0], ary[1] + 1};
		Node tempNode = new Node(temp, node);
		placesToGo.add(tempNode);
	    }
	if ((ary[0] >= 0 && ary[0] < maze.length) && (ary[1] - 1 >= 0 && ary[1] - 1 < maze[1].length))
	    if(maze[ary[0]][ary[1] - 1] != '.' && maze[ary[0]][ary[1] - 1] != '#') {
		int[] temp = {ary[0], ary[1] - 1};
		Node tempNode = new Node(temp, node);
		placesToGo.add(tempNode);
	    }
	if ((ary[0] + 1 >= 0 && ary[0] + 1 < maze.length) && (ary[1] >= 0 && ary[1] < maze[1].length))
	    if(maze[ary[0] + 1][ary[1]] != '.' && maze[ary[0] + 1][ary[1]] != '#') {
		int[] temp = {ary[0] + 1, ary[1]};
		Node tempNode = new Node(temp, node);
		placesToGo.add(tempNode);
	    }
	if ((ary[0] - 1 >= 0 && ary[0] - 1 < maze.length) && (ary[1] >= 0 && ary[1] < maze[1].length))
	    if(maze[ary[0] - 1][ary[1]] != '.' && maze[ary[0] - 1][ary[1]] != '#') {
		int[] temp = {ary[0] - 1, ary[1]};
		Node tempNode = new Node(temp, node);
		placesToGo.add(tempNode);
	    }
    }
   
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
    }


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    


       
    
    

}

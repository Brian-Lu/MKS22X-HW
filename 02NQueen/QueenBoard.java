public class QueenBoard{
    private int[][] board;
    public QueenBoard(int num) {
	board = new int[num][num];
    }
    public boolean addQueen(int row, int col) {
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col + offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row - offset][col + offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }
    public boolean removeQueen(int row, int col) {
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }
    public String toString() {
	String ret = "";
	for (int i = 0; i < board.length; i++) {
	    for (int x = 0; x < board.length; x++) {
		ret += board[i][x] + "\t";
	    }
	    ret += "\n";
	}
	return ret;
    }
    public void printSolution() {
	String ret = "";
	for (int i = 0; i < board.length; i++) {
	    for (int x = 0; x < board.length; x++) {
		if (board[i][x] == 1) {
		    ret += " Q ";
		}
		else {
		    ret += " _ ";
		}
	    }
	    System.out.println(ret);
	    ret = "";
	}
    }    
    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve()
    {
	return solveH(0);
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	if (col >= board.length) {
	    return true;
	}
	int x = 0;
	while (x < board.length) {
	    if (addQueen(x, col)) {
		if (solveH(col + 1)) {
		    return true;
		}
		else {
		    removeQueen(x, col);
		}
	    }
	    x += 1;
	}
	return false;
    }
    public static void main (String[]args) {
	QueenBoard N = new QueenBoard(Integer.parseInt(args[0]));
	N.solve();
	N.printSolution();
    }
}

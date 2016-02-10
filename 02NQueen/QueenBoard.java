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
		    ret += "Q" + "\t";
		}
		else {
		    ret += "_" + "\t";
		}
	    }
	}
	System.out.println(ret);
    }
}

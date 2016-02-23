public class KnightBoard {
    public int[][] board;
    public int counter;
    public KnightBoard(int x) {
	board = new int[x][x];
	counter = 0;
    }
    public KnightBoard(int x, int y) {
	board = new int[x][y];
	counter = 0;
    }
    public void solve() {
	if (solveH(0, 0, 0, board.length)) {
	    printSolution();
	} 
	else {
	    System.out.println("No Can Do");
	}
    }
    public boolean solveH(int row, int col, int index, int N) {
	if (board[row][col] != 0) {
	    return false;
	}
	board[row][col] = counter++;
	if (index == N * N - 1) {
	    return true;
	}
	if (able(row + 1, col + 2, N) && solveH(row + 1, col + 2, index + 1, N)) {
	    return true;
	}
	if (able(row + 1, col - 2, N) && solveH(row + 1, col - 2, index + 1, N)) {
	    return true;
	}
	if (able(row - 1, col + 2, N) && solveH(row - 1, col + 2, index + 1, N)) {
	    return true;
	}
	if (able(row - 1, col - 2, N) && solveH(row - 1, col - 2, index + 1, N)) {
	    return true;
	}
	if (able(row + 2, col + 1, N) && solveH(row + 2, col + 1, index + 1, N)) {
	    return true;
	}
	if (able(row + 2, col - 1, N) && solveH(row + 2, col - 1, index + 1, N)) {
	    return true;
	}
	if (able(row - 2, col + 1, N) && solveH(row - 2, col + 1, index + 1, N)) {
	    return true;
	}
	if (able(row - 2, col - 1, N) && solveH(row - 2, col - 1, index + 1, N)) {
	    return true;
	}
	board[row][col] = 0;
	counter--;
	return false;

    }
    public boolean able(int row, int col, int tab) {
	if (row >= 0 && col >= 0 && tab > row && tab > col) {
	    return true;
	}
	return false;
    }
    public void printSolution(){
	String ret1 = "";
	for(int i = 0;i < board.length; i++){
	    ret1 += printH(i) + "\n";
	}
	System.out.println(ret1);
    }
    public String printH(int n){
	String ret = "";
	for(int i = board[0].length - 1; i >= 0; i--){
	    if(board[n][i]<10){
		ret += board[n][i] + "  ";
	    }else{
		ret += board[n][i] + " ";
	    }
	}
	return ret;
    }
}

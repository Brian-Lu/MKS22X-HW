public class KnightBoard{
    private int[][] board;
    public KnightBoard(int x){
	board = new int[x][x];
    }
    public KnightBoard(int row,int col){
	board = new int[row][col];
    }
    public boolean solveH(int row, int col, int counter){
	if(row >= board.length || row<0 || col >= board[0].length || col < 0){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int a = 0; a < board[0].length; a++){
                if(board[i][a] >= counter){
                    board[i][a] = 0;
                }
            }
        }
        if(counter == board.length*board[0].length + 1){
	    return true;
	}
	else if (board[row][col] > 0){
	    return false;
	}
	else {
	    board[row][col] = counter;
	    return (solveH(row + 1, col + 2, counter + 1) || solveH(row + 1, col - 2, counter + 1) ||
		    solveH(row + 2, col + 1, counter + 1) || solveH(row + 2, col - 1, counter + 1) ||
		    solveH(row - 1, col + 2, counter + 1) || solveH(row - 1, col - 2, counter + 1) ||
		    solveH(row - 2, col + 1, counter + 1) || solveH(row - 2, col - 1, counter + 1));
	}
    }
    public boolean solve(){
	return solveH(0, 0, 1);
    }
    public void printSolution(){
	String ret = "";
	for(int i = 0; i < board.length; i++){
	    for (int a = 0; a < board[0].length; a++) {
		if (board[i][a] < 10) {
		    ret += " " + board[i][a] + " ";
		}
		else {
		    ret += board[i][a] + " ";
		}
	    }
	    ret += "\n";
	}
	System.out.println(ret);
    }
}

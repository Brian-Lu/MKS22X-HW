public class NQueen{
    int[][] board;
    int queens;
    public NQueen(int num) {
	board = new int[num][num];
	queens = num;
    }
    public void addQueen(int x, int y) {
	board[x][y] = 1;
	int a = x + 1;
	for(int i = y + 1; i < board.length; i++){
	    if(a < board.length){
		board[a][i] -= 1;
		a += 1;
	    }
	}
	a = x - 1;
	for(int i = col + 1; i < board.length; i++){
	    if(a > 0) {
		board[a][i] -= 1;
		a -= 1;
	    }
	}
	for(int i = x + 1; i < board.length; i++){
	    board[x][i] -= 1;
	}
    }
    public void removeQueen(int x, int y) {
        board[x][y] = 0;
	int p = 1;
	int q = 1;
	for(int i = y + 1; i < board.length;i++){
	    board[x][i]=board[x][i] + 1;
	}
	for(int i = x - 1; i >= 0;i--){
	    board[i][y + p] = board[i][y+p] + 1;
	    p++;
	}
	for(int i = x;i <board.length - 1; i++){
	    board[x+q][y+q]= board[x+q][y+q] + 1;
	    q++;
	}
    }

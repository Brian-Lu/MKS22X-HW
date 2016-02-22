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
}

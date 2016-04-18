public class Driver {
    public static void main(String[] args) {
	BetterMaze x;
	if (args.length == 0) {
	    x = new BetterMaze("data1.dat");
	}
	else{
	    x = new BetterMaze("data2.dat");
	}
	x.setAnimate(true);
	//x.solveBFS();
	x.solveDFS();
    }
}

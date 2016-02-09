public class Recursion implements hw01 {
    public String name() {
	return "Lu,Brian";
    }
    public double sqrt(double x) {
	if (x < 0) {
	    throw new IllegalArgumentException();
	}
	return findRoot(x, 1); 
    }
    public double findRoot(double x, double guess) {
	if (x == 0) {
	    return 0.0;
	}
	if ((Math.abs(Math.pow(guess, 2) - x))/ x * 100 < 0.000001) {
	    return guess;
	}
	guess = (x / guess + guess) / 2;
	return findRoot(x, guess);
    }
}

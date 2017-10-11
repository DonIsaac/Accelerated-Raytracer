package renderer;

public class Utils {
	/**<a href="https://en.wikipedia.org/wiki/Machine_epsilon">Machine Epsilon</a>*/
	public static double EPSILON = createE();
	
	/**
	 * Determines if two doubles are equal to each other while factoring in imprecision.
	 * @param a The first double to compare
	 * @param b The second double to compare
	 * @return <code>true</code> if equal, <code>false</code> otherwise
	 */
	public static boolean nearlyEquals(double a, double b){
		if(a==b)
			return true;
		double absA=Math.abs(a);
		double absB=Math.abs(b);
		double diff=Math.abs(a-b);
		
		if (a == 0 || b == 0 || diff < Float.MIN_NORMAL) {
			// a or b is zero or both are extremely close to it
			// relative error is less meaningful here
			return diff < (EPSILON * Float.MIN_NORMAL);
		} else { // use relative error
			return diff / Math.min((absA + absB), Float.MAX_VALUE) < EPSILON;
		}
	}
	/**
	 * Determines the Machine Epsilon at runtime.
	 * @return Machine Epsilon
	 */
	private static double createE(){
		double e=.5;
		while(1.0+e>1.0){
			e*=.5;
		}
		return e;
	}
}

public class Time {
	public static double timeStarted = System.nanoTime();

	public static double getTime() {
		// Total elapsed time in seconds
		return (System.nanoTime() - timeStarted) * 1E-9; 
	}

}

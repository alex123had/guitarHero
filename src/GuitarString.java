public class GuitarString {
	RingBuffer str;
	
	public GuitarString(double frequency) {
		int f = (int) ((44100/frequency)+0.5);
		str = new RingBuffer(f);
	}
	public GuitarString(double[] init) {
		str = new RingBuffer(init.length);
		for (int i = 0; i<str.size(); i++) {
			str.enqueue(init[i]);
		}
	}
	public void pluck() {
		
		double noise = ((double)Math.random())-0.5;
		
	}
	public void tic() {
		
	}
	public double sample() {
		return 0.0;
	}
	public int time() {
		return 0;
	}
	
}

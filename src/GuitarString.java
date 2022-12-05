public class GuitarString {

	RingBuffer ringBuffer;
	int size;
	int ticks;
	
	//use a sampling rate of 44100
	public GuitarString(double frequency) {
		int N = (int) ((44100/frequency)+0.5);
		ringBuffer = new RingBuffer(N);
		for (int i = 0; i<N; i++) {
			ringBuffer.enqueue(0);
		}
		size = N;
		ticks = 0;
	}
	
	//size and values are given by the array
	public GuitarString(double[] init) {
		ringBuffer = new RingBuffer(init.length);
		for (int i = 0; i<init.length; i++) {
			ringBuffer.enqueue(init[i]);
		}
	}
	
	//set the buffer to white noise
	public void pluck() {
		for (int i = 0; i<size; i++) {
		ringBuffer.dequeue();
		double noise = ((double)Math.random())-0.5;
		ringBuffer.enqueue(noise);
		}
	}
	
	//advance the simulation one time step
	public void tic() {
		double nV = ((ringBuffer.dequeue()+ringBuffer.peek())/2)*0.994;
		ringBuffer.enqueue(nV);
		ticks++;
	}
	
	//return the current sample
	public double sample() {
		return ringBuffer.peek();
	}
	
	//return number of tics
	public int time() {
		return ticks;
	}
}
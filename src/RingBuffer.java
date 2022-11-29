public class RingBuffer {
	double[] buffer;
	
	int first;
	int last;
	
	public RingBuffer(int capacity) {
		buffer = new double[capacity];
	}
	
	public int size() {
		int count = 0;
		for (int i = first; i<last; i++) {
			
		}
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public boolean isFull() {
		return false;
	}
	
	public void enqueue(double x) {
		if (!isFull()) {
			
		}
	}
	
	public double dequeue() {
		return 0.0;
	}
	
	public double peek() {
		return 0.0;
	}
	
	public String toString() {
		return null;
	}
}

public class RingBuffer {
<<<<<<< HEAD
	double[] buffer;
	
	int first;
	int last;
=======
	
	
>>>>>>> b56b43c5ebdbbe022bf30ac4b224b9915457daa4
	
	public RingBuffer(int capacity) {
		buffer = new double[capacity];
	}
	
	public int size() {
		int count = 0;
<<<<<<< HEAD
		for (int i = first; i<last; i++) {
			
		}
=======
		buffer = new RingBuffer[10];
		for(int i = 0; i < buffer.length; i++) {
			count++;
		}
		return count;
>>>>>>> b56b43c5ebdbbe022bf30ac4b224b9915457daa4
	}
	
	public boolean isEmpty() {
		
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

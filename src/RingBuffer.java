
public class RingBuffer {
	
	
	
	public RingBuffer(int capacity) {
		
	}
	
	public int size() {
		int count = 0;
		buffer = new RingBuffer[10];
		for(int i = 0; i < buffer.length; i++) {
			count++;
		}
		return count;
	}
	
	public boolean isEmpty() {
		
	}
	
	public boolean isFull() {
		return false;
	}
	
	public void enqueue(double x) {
		
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

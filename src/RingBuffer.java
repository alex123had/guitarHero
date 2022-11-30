import java.util.NoSuchElementException;

public class RingBuffer {
	double[] buffer;
	int size = 0;
	int first;
	int last;
	
	public RingBuffer(int capacity) {
		buffer = new double[capacity];
		first = 0; 
		last = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public boolean isFull() {
		return size == buffer.length;
	}
	
	public void enqueue(double x) {
		
		if (isFull()) {
			throw new IllegalStateException();
		}
		
		buffer[last]= x;
		last++;
		
		if (last >= buffer.length-1) {
			last = 0;
		}
		
		size++;		
	}
	
	public double dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		double temp = buffer[first];
		first++;
		
		size--;
		
		if (first>= buffer.length) {
			first = 0;
		}
		
		return temp;
	}
	
	public double peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return buffer[first];
	}
	
	public String toString() {
		String temp = "[";
		
		for (int i = first; i<last-1; i++) {
			temp = temp + buffer[i] + ", ";
		}
		temp += buffer[last-1] + "]";
	
		return temp;
	}
}


import java.util.NoSuchElementException;

public class RingBuffer {
	double[] buffer;
	int size = 0;
	int first = 0;
	int last = 0;
	
	public RingBuffer(int capacity) {
		buffer = new double[capacity];
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
		
		if (last == buffer.length-1) {
			last = 0;
		}
		else {
			last++;
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
		for (int i = 0; i<buffer.length; i++) {
			temp = temp + buffer[i] + ",";
		}
		temp = buffer[last] + "]";
		
		return temp;
	}
}


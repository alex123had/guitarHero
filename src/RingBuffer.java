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

    buffer[last] = x;
    
    last = (last+1)%buffer.length;

    size++;
  }

  public double dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    double temp = buffer[first];
    buffer[first] = 0.0;

    size--;

    first = (first+1)%buffer.length;
  
    return temp;
  }

  public double peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return buffer[first];
  }

  public String toString() {
	 if(isEmpty()) {
		 return "[";
	 }
	 String phrase = "[";
	 for (int i = 0; i<size()-1;i++) {
		 phrase += ""  + peek() + ", ";
		 enqueue(dequeue());
	 }
	 
	 phrase+= peek();
	 enqueue(dequeue());
	 
	 phrase+="]";
	 
	 return phrase;
  }
}

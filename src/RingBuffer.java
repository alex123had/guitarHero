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

    if (isEmpty()) {
      first = 0;
      last = 0;
    }

    buffer[last] = x;
    last++;

    if (last >= buffer.length - 1) {
      last = 0;
    }

    size++;
  }

  public double dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    double tArray[] = new double[buffer.length];

    double temp = buffer[first];
    buffer[first] = tArray[first];
    first++;

    size--;

    if (first >= buffer.length) {
      first = 0;
    }

    if (size == 0) {
      first = 0;
      last = 0;
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
    double inOrder[] = new double[size()];
    int index=0;

    if (last <= first && !isEmpty()) {
      for (int i = first; i < buffer.length; i++){
        inOrder[index] = buffer[i];
        index++;
      }

      for (int j = 0; j < last; j++) {
        inOrder[index] = buffer[j];
        index++;
      }
      
    } else {
      index = 0;
      for (int x = 0; x < last; x++) {
        inOrder[index] = buffer[x];
        index++;
      }
    }

    String temp = "[";

    if (isEmpty()) {
      return "[]";
    }

    for (int y = 0; y < inOrder.length; y++) {
      temp += inOrder[y] + ",";
    }
    return temp;
  }
}

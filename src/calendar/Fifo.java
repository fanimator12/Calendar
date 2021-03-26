package calendar;

public class Fifo {

  private Object[] elements = null;
  private int inDex = 0;
  private int outDex = 0;

  public Fifo(int fifoSize) {
    elements = new Object[fifoSize];
  }

  public boolean isEmpty() {
    return (elements[0] == null ? true : false);
  }

  public boolean isFull() {
    return (elements[elements.length-1] != null);
  }

  public void enqueue(Object o) {
    if (inDex >= elements.length) {
      inDex = 0;
    }
    elements[inDex++] = o;
  }

  public Object dequeue() {
    return elements[outDex++];
  }

}

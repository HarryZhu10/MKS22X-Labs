public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    size = 0;
    @SuppressWarnings("unchecked")
    E[] data = (E[]) new Object[10];
    if (data.length == 0) {
    start = 0;
    end = 0;
  } else {
    start = 0;
    end = data.length - 1;
  }
  }
  public MyDeque(int initialCapacity){
    size = 0;
    @SuppressWarnings("unchecked")
    E[] data = (E[]) new Object[initialCapacity];
    if (data.length == 0) {
    start = 0;
    end = 0;
  } else {
    start = 0;
    end = data.length - 1;
  }

  }

  public int size(){
    return size;
  }
  public String toString(){
    String result = "[";
    for (int i = 0; i < data.length; i ++) {
      result += data[i];
      if (i != data.length - 1) {
        result += ", ";
      } else {
        result += "]";
      }
    }
   }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}

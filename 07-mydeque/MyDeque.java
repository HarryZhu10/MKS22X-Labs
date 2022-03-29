import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque() {
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

  public MyDeque(int initialCapacity) {
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

  public String toString() {
    String result = "[";
    for (int i = 0; i < data.length; i ++) {
      result += data[i];
      if (i != data.length - 1) {
        result += ", ";
      } else {
        result += "]";
      }
    }
    return result;
   }

  public void addFirst(E element) {
    if (start - 1 < 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    } else {
      data[start - 1] = element;
      start -= 1;
    }
   }

  public void addLast(E element) {
    if (start + 1 > data.length - 1) {
      data[0] = element;
      end = 0;
    } else {
      data[end + 1] = element;
      end += 1;
    }
  }
  public E removeFirst() {
    if (start + )
  }


  public E removeLast() { }

  public E getFirst() {
    return data[start];
   }
  public E getLast() {
    return data[end];
  }

  private E[] resize (E[] data, int start, int end, int size) {
    if (size + 1 >= data.length) {
      @SuppressWarnings("unchecked")
      E[] result = (E[]) new Object[data.length * 2 + 1];
      if (start < end) {
        for (int i = 0; i < data.length; i ++) {
          result[i] = data[i];
        }
      } else {
        int count = 0;
        for (int i = start; i < data.length; i ++) {
          result[i - start] = data[i];
          count ++;
        }

        for (int i = 0; i < start; i ++) {
          result[count] = data[i];
          count ++;
        }
      }
      return result;
    } else {
      return data;
    }

  }
}

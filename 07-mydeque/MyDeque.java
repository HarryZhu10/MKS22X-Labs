import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque() {
    size = 0;
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[10];
    data = d;
    start = data.length / 2;
    end = start - 1;
  }

  public MyDeque(int initialCapacity) {
    if (initialCapacity == 0) {
      initialCapacity = 2;
    }
    size = 0;
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    start = data.length / 2;
    end = start - 1;

  }

  public int size(){
    return size;
  }



  public String toString() {
    String result = "[";
    if (size != 0) {
      if (start < end) {
        for (int i = start; i < end; i ++) {
          result += data[i] + ", ";
        }
        result += data[end];
      } else {
        for (int i = start; i < data.length; i ++) {
          result += data[i] + ", ";
        }

        for (int i = 0; i < end; i ++) {
          result += data[i] + ", ";
        }
        result += data[end];
      }
  }
    return result += "]";
   }





  public void addFirst(E element) {
    if (element == null) {
      throw new NullPointerException("The element, " + element + " is null.");
    }
    if (size == data.length) {
      resize();
    }

    if (start == 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    } else {
      data[start - 1] = element;
      start -= 1;
    }
    size ++;
   }


  public void addLast(E element) {
    if (element == null) {
      throw new NullPointerException("The element, " + element + " is null.");
    }
    if (size == data.length) {
      resize();
    }
    if (end + 1 == data.length) {
      end = 0;
      data[end] = element;
    } else {
      data[end + 1] = element;
      end ++;
    }
    size ++;
  }



  public E removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException ("No element to be removed");
    }
    E temp = data[start];
    data[start] = null;
    if (start == data.length - 1) {
      start = 0;
    } else {
      start ++;
    }
    size --;
    return temp;
  }


  public E removeLast() {
    if (size == 0) {
      throw new NoSuchElementException ("No element to be removed");
    }
    E temp = data[end];
    data[end] = null;
    if (end == 0) {
      end = data.length - 1;
    } else {
      end --;
    }
    size --;
    return temp;
  }

  public E getFirst() {
    if (size == 0) {
      throw new NoSuchElementException ("No element to be removed");
    }
    return data[start];
   }
  public E getLast() {
    if (size == 0) {
      throw new NoSuchElementException ("No element to be removed");
    }
    return data[end];
  }

  private void resize () {
      @SuppressWarnings("unchecked")
      E[] result = (E[]) new Object[data.length * 2];
      if (start < end) {
        int fill = data.length / 2;
        for (int i = 0; i < fill; i ++) {
          result[i] = null;
        }
        for (int i = 0; i < data.length; i ++) {
          result[i + fill] = data[i];
        }
        for (int i = data.length + fill; i < data.length * 2; i ++) {
          result[i] = null;
        }
        end += fill;
        start += fill;
      } else {
        for(int i = 0; i <= end; i ++){
          result[i] = data[i];
        }
        for(int i = start; i < data.length; i ++){
          result[i + data.length] = data[i];
        }
        start += data.length;
      }
      data = result;

  }


}

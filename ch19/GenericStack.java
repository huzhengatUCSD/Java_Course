package ch19;

//revision based on ch11.MyStack;

import java.util.ArrayList;
public class GenericStack<T> {
  private ArrayList<T> list = new ArrayList<T>();
   
  public int getSize() {
    return list.size();
  }

  public T peek() {
    return list.get(getSize() - 1);
  }

  public void push(T o) {
    list.add(o);
  }

  public T pop() {
    T o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  @Override
  public String toString() {
    return "stack: " + list.toString();
  }
}

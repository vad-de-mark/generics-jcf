package uz.itpu.lecture.generics;

public class ValueHolder<T> {

  private T value;
  
  public T get() {
    return value;
  }
  
  public void set(T value) {
    this.value = value;
  }
  
  public boolean isSet() {
    return value != null;
  }
  
  public static <T> ValueHolder<T> hold(T value) {
    var holder = new ValueHolder<T>();
    holder.set(value);
    return holder;
  }
}

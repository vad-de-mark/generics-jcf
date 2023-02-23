package uz.itpu.lecture.generics;

import com.sun.jdi.Value;
import java.io.Serializable;

public class Main {

  public static void main(String[] args) {
    ValueHolder<Integer> ageHolder = ValueHolder.hold(42);
    ValueHolder<Object> holder = new ValueHolder<>();
    
    Main.<Number>copy(ageHolder, holder);
    
    print(holder);

    System.out.println("Tens of age: " + tens(ageHolder));
  }

  // Boundary example
  private static int tens(ValueHolder<? extends Number> ageHolder) {
    if (!ageHolder.isSet()) {
      return 0;
    }
    return ageHolder.get().intValue() / 10;
  }

  // Wildcard example
  private static void print(ValueHolder<?> holder) {
    System.out.printf("Holder isSet = %s%n", holder.isSet());
    if (holder.isSet()) {
      System.out.printf("Holder value = %s%n", holder.get());
    }
  }

  // Interface combination example
  <T extends Comparable<T> & Runnable> void runTheSmallest(T _1, T _2) {
    if (_1.compareTo(_2) < 0) {
      _1.run();
    } else {
      _2.run();
    }
  }
  
  // PECS example
  static <T> void copy(ValueHolder<? extends T> src, ValueHolder<? super T> dest) {
    dest.set(src.get());
  }
}

package uz.itpu.lecture.jcf;

import java.util.*;
import java.util.function.Consumer;

public class IteratingCollection {

  public static void main(String[] args) {
    Collection<Integer> col = new ArrayList<>();
    
    // Adding to collection
    col.add(42);
    col.add(7);
    col.add(14);
    
    // Checking containing of an element in collection
    System.out.println(col.contains(14));
    
    // Remove element from collection
    col.remove(14);

    // Iterating via for-each (implicit external)
    for (Integer el : col) {
      System.out.println(el);
    }
    
    // Iterating via iterator (explicit external)
    var it = col.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    // Iterating via forEach (internal)
    // With anonymous class
    col.forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer el) {
        System.out.println(el);
      }
    });
    
    // With lambda
    col.forEach(el -> System.out.println(el));
    
    // With method reference
    col.forEach(System.out::println);
  }

}

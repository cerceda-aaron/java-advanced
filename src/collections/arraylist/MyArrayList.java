package collections.arraylist;

import java.util.Arrays;

public class MyArrayList <E>{
   private int DEFAULT_CAPACITY = 10;
   private int size = 0;
   private E[] arr;

   public MyArrayList() {
       arr = (E[]) new Object[DEFAULT_CAPACITY];
   }

   public void add(E e) {
       if(size == arr.length) {
            increase();
       }
       arr[size++] = e;
   }

   public E get(int i) {
       if(i >= size || i < 0) {
           throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
       }
       return (E) arr[i];
   }

   public E remove(int i) {
       if(i >= size || i < 0) {
           throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
       }

       E removedElement = (E) arr[i];
       for(int j = i; j < size - 1; j++) {
           arr[j] = arr[j + 1];
       }

       arr[--size] = null; // prevent memory leaks
       return removedElement;
   }

   public int size() {
       return size;
   }

   public boolean isEmpty() {
       return size == 0;
   }

   public void clear() {
       arr = (E[]) new Object[DEFAULT_CAPACITY];
       size = 0;
   }

   private void increase() {
       int newSize = arr.length * 2;
       arr = Arrays.copyOf(arr, newSize);
   }

}

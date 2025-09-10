
package generics;

import java.util.*;

public class Examples {
    // 1. Java Generic Class
    // Pair<A, B> is a generic class that can hold two values of any types.
    // Demonstrates how to create a class with type parameters.
    public static class Pair<A, B> {
        private A first;
        private B second;
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
        public A getFirst() { return first; }
        public B getSecond() { return second; }
    }

    // 2. Java Generic Type
    // Container<T> uses a single type parameter T to store and retrieve an item.
    // Shows the use of generic type naming conventions.
    public static class Container<T> {
        private T item;
        public Container(T item) { this.item = item; }
        public T getItem() { return item; }
        public void setItem(T item) { this.item = item; }
    }

    // 3. Java Generic Method
    // getFirstElement(List<T> list) is a generic method that works with any type of list and returns its first element.
    // The method itself is parameterized.
    public static <T> T getFirstElement(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }

    // 4. Java Generics Bounded Type Parameters
    // multiply(T a, T b) restricts T to subclasses of Number, ensuring only numeric types are accepted.
    // It multiplies two numbers.
    public static <T extends Number> double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    // 5. Java Generics and Inheritance
    // AnimalBox<T extends Animal> can hold any subclass of Animal.
    // Demonstrates how generics interact with inheritance.
    public static class Animal {}
    public static class Dog extends Animal {}
    public static class AnimalBox<T extends Animal> {
        private T animal;
        public AnimalBox(T animal) { this.animal = animal; }
        public T getAnimal() { return animal; }
    }

    // 6. Java Generic Classes and Subtyping
    // MyList<E, T> is a generic interface extending List<E>.
    // MyStringList implements it, showing how generic classes/interfaces can be subtyped.
    public interface MyList<E, T> extends List<E> {}
    public static class MyStringList implements MyList<String, Integer> {
        private List<String> list = new ArrayList<>();
        public int size() { return list.size(); }
        public boolean isEmpty() { return list.isEmpty(); }
        public boolean contains(Object o) { return list.contains(o); }
        public Iterator<String> iterator() { return list.iterator(); }
        public Object[] toArray() { return list.toArray(); }
        public <U> U[] toArray(U[] a) { return list.toArray(a); }
        public boolean add(String e) { return list.add(e); }
        public boolean remove(Object o) { return list.remove(o); }
        public boolean containsAll(Collection<?> c) { return list.containsAll(c); }
        public boolean addAll(Collection<? extends String> c) { return list.addAll(c); }
        public boolean addAll(int index, Collection<? extends String> c) { return list.addAll(index, c); }
        public boolean removeAll(Collection<?> c) { return list.removeAll(c); }
        public boolean retainAll(Collection<?> c) { return list.retainAll(c); }
        public void clear() { list.clear(); }
        public String get(int index) { return list.get(index); }
        public String set(int index, String element) { return list.set(index, element); }
        public void add(int index, String element) { list.add(index, element); }
        public String remove(int index) { return list.remove(index); }
        public int indexOf(Object o) { return list.indexOf(o); }
        public int lastIndexOf(Object o) { return list.lastIndexOf(o); }
        public ListIterator<String> listIterator() { return list.listIterator(); }
        public ListIterator<String> listIterator(int index) { return list.listIterator(index); }
        public List<String> subList(int fromIndex, int toIndex) { return list.subList(fromIndex, toIndex); }
    }

    // 7. Java Generics Wildcards
    // printListWildcard(List<?> list) uses a wildcard to accept a list of any type and prints its elements.
    public static void printListWildcard(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // 8. Java Generics Upper Bounded Wildcard
    // sumNumbers(List<? extends Number> list) accepts lists of any subclass of Number (e.g., Integer, Double) and sums their values.
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // 9. Java Generics Unbounded Wildcard
    // printAnyList(List<?> list) works with lists of any type, printing each element.
    public static void printAnyList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + "::");
        }
        System.out.println();
    }

    // 10. Java Generics Lower bounded Wildcard
    // addInteger(List<? super Integer> list) accepts lists of Integer or its supertypes (Number, Object) and adds an integer to the list.
    public static void addInteger(List<? super Integer> list) {
        list.add(42);
    }

    // 11. Subtyping using Generics Wildcard
    // subtypingWildcardDemo() shows that List<? extends Integer> is a subtype of List<? extends Number>.
    public static void subtypingWildcardDemo() {
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number> numList = intList; // OK
    }

    // 12. Java Generics Type Erasure
    // Erased<T extends Comparable<T>> demonstrates that generic type information is removed at runtime (type erasure).
    public static class Erased<T extends Comparable<T>> {
        private T data;
        public Erased(T data) { this.data = data; }
        public T getData() { return data; }
    }

    // 13. Can I Create an Array of Generics in Java?
    // You cannot create generic arrays directly (new T[10] is not allowed).
    // Instead, use List<T> as shown in createList().
    public static <T> List<T> createList() {
        return new ArrayList<>();
    }
}

package generics;

/*
* In similar way, we can create generic interfaces in Java. We can also have multiple type parameters as in Map
* interface. Again we can provide parameterized value to a parameterized type also, for example:
* new HashMap<String, List<String>>(); is valid
* */
public interface Comparable<T>{
    public int compareTo(T o);
}

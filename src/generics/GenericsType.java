package generics;

public class GenericsType<T>{
    private T t;
    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String[] args) {

        /*
        *
        * We don't need to do type-casting, and we can remove ClassCastException error at runtime. If we don't
        * provide the type at the creation time, the compiler will warn that "GenericsType is a raw type. References
        * to generic type GenericsType<T> should be parameterized". When we don't provide the type, the type becomes
        * Object, and hence, it allows both String and Integer objects. But, we should always try to avoid this because
        * we will have to use type casting while working on the raw type, which can produce runtime errors.
        *
        * */

        GenericsType<String> type = new GenericsType<>();
        type.set("Pankaj"); // valid

        GenericsType type1 = new GenericsType(); // raw type
        type1.set("Pankaj"); //valid
        type1.set(10); // valid and autoboxing support
    }
}

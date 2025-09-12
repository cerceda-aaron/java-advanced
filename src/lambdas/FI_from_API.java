package lambdas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FI_from_API {
    public static void main(String[] args) {
        FI_from_API fiFromApi = new FI_from_API();
        //fiFromApi.predicate();
        //fiFromApi.consumer();
        fiFromApi.function();
    }

    public void predicate() {
        /*
        *
        * Predicate<T> represents a single-argument function that returns a boolean value.
        * It is used when you need to test or filter a single value.
        *
        * BiPredicate<T, S> represents a function that takes two arguments and returns a boolean
        * value. It is used when you need or filter a pair of values.
        *
        * */

        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City")); // true

        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 8)); // false (length is 12)
    }

    public void supplier() {

        // Supplier<T> represents a function that supplies a result of type T.
        // It does not take any arguments, only returns a value.

        Supplier<StringBuilder> supSb = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSb.get().append("SK")); // Supplier SB: SK

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get()); // supplier time: 09:11:39.121101600

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get()); // 0.782467864130131
    }

    public void consumer() {

        /*
        * It represents an operation that accepts a single input argument and returns no result.
        * */

        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC);

        var mapCapitalCities = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital of: " + value);
        mapCapitalCities.forEach(mapPrint);
    }

    public void function() {
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow"));

        BiFunction<String, String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("William", "Shakespeare"));

        BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("Wiiliam", "Shakespeare"));
    }

    public void unaryBinaryOperator() {
        UnaryOperator<String> unaryOp = name -> "My name is" + name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Sean"));

        BinaryOperator<String> binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("William", "Shakespeare"));
    }
}

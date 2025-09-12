package lambdas;

import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: " + lambda.isNegative(-1));
        System.out.println("Evaluate: " + lambda.isNegative(+1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(+1));

        int x = 4;
        System.out.println("Is " + x + " even? " + check(4, n -> n % 2 == 0)); // true

        x = 7;
        System.out.println("Is " + x + " even? " + check(7, n -> n % 2 == 0)); // false

        String name = "Mr. Joe Bloggs";
        System.out.println("Does " + name + " start with Mr. ? " +
                check("Mr. Joe Bloggs", s -> s.startsWith("Mr."))); // true

        name = "Ms. Ann Bloggs";
        System.out.println("Does " + name + " starts with Mr. ? " +
                check("Ms. Ann Bloggs", s -> s.startsWith("Mr."))); // false

    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}

package streams;

import javax.smartcardio.ATR;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class BuildStreams {
    public static void main(String[] args){

        // from Stream.of
        Stream<Integer> stream1 = Stream.of(1,2,3);
       // System.out.println(stream1.count());

        Stream<String> stream2 = Stream.of("a", "b", "c", "d");
       // System.out.println(stream2.count());

        // From collections
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> streamList = list.stream();

        // From Arrays
        String[] array = {"a", "b", "c"};
        Stream<String> streamArray = Arrays.stream(array);

        // from Files
        Path path = Paths.get("file.txt");
        //Stream<String> lines = Files.lines(path);

        // From Primitive Data Types - there are specialized streams: IntStream, LongStream, DoubleStream
        IntStream intStream = IntStream.range(1,5); // 1,2,3,4

        // Infinite Streams
        Stream<Integer> infStream = Stream.generate(() -> {
           return (int) (Math.random() * 10);
        });

        Stream<Integer> infStream2 = Stream.iterate(2, n -> n + 2);

        /*
        * Intermediate Operations return a new stream and are lazy (do not process data until a terminal operation is called).
        * They can be chained together.
        *
        * filter - Select elements matching a predicate - stream.filter(x -> x > 5)
        * map - Transforms each element - stream.map(x -> x * 2)
        * flatMap - Flattens nested structures - stream.flatMap(List::stream)
        * distinct - Removes duplicates - stream.distinct()
        * sorted - Sorts elements - stream.sorted() or stream.sorted(Comparator.reverseOrder())
        * peek - Performs action for debugging
        * limit - Truncates stream to max size - stream.limit(3)
        * skip - Skips first N elements - stream.skip(2)
        *
        * */

        // Filter - Filters elements by a predicate.

        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5)
                .filter(x -> x % 2 == 0); // Keeps: 2, 4

        // Map - Transforms each element.
        Stream<String> s2 = Stream.of("a", "b", "c")
                .map(str -> str.toUpperCase()); //Becomes: "A", "B", "C"

        // flatMap - Flattens nested structures.
        List<List<String>> listNested = Arrays.asList(
                Arrays.asList("a", "b"), Arrays.asList("c", "d")
        );

        Stream<String> s3 = listNested.stream().flatMap(Collection::stream); // Becomes: "a", "b", "c", "d"

        // Distinct - Removes duplicate elements.
        Stream<Integer> s4 = Stream.of(1, 2, 2, 3, 3, 3)
                .distinct(); // Keeps: 1, 2, 3

        // Sorted - Sorts elements (natural order or comparator).
        Stream<Integer> s5 = Stream.of(5, 3, 4, 1, 2)
                .sorted(); // Becomes: 1, 2, 3, 4, 5

        Stream<Integer> s6 = Stream.of(5, 3, 4, 1, 2)
                .sorted(Comparator.reverseOrder()); // Becomes: 5, 4, 3, 2, 1

        // Peek - Performs an action for each element (useful for debugging).
        Stream<String> s7 = Stream.of("a", "b", "c")
                .peek(System.out::println); // Prints each element, then continues pipeline

        // Limit - Truncates the stream to a maximum number of elements.
        Stream<Integer> s8 = Stream.of(1, 2, 3, 4, 5)
                .limit(3); // Keeps: 1, 2, 3

        // Skip - Skips the first N elements.
        Stream<Integer> s9 = Stream.of(1, 2, 3, 4, 5)
                .skip(2); // Keeps: 3, 4, 5



        /*
        * Terminal Operations produce a result or a side-effect and end the stream pipeline.
        *
        * forEach - Performs action for each element - stream.forEach(System.out::println)
        * collect - Converts stream to collection - stream.collect(Collectors.toList())
        * reduce - Reduces elements to a single value - stream.reduce(0, Integer::sum)
        * count - Counts elements - stream.count()
        * anyMatch - Checks if any element matches predicate - stream.anyMatch(x -> x > 5)
        * allMatch - Checks if all elements match predicate  - stream.allMatch(x -> x > 0)
        * noneMatch - checks if no elements match predicate - stream.noneMatch(x -> x < 0)
        * findFirst - Returns first element (optional) - stream.findFirst()
        * findAny - Returns any element (optional) - stream.findAny()
        * min - Finds minimum - stream.min(Comparator.naturalOrder())
        * max - Finds maximum - stream.max(Comparator.naturalOrder())
        * toArray - Converts stream to array - stream.toArray()
        * */

        //forEach
        Stream.of("aaple", "banana", "cherry")
                .forEach(System.out::println);// Output: apple, banana, cherry (each on a new line)

        // collect
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList()); // ["a","b","c"]

        // reduce
        int product = Stream.of(2,3,4)
                .reduce(1, (a, b) -> a * b); // Output: 24

        // count
        long count = Stream.of("a", "b", "c", "d")
                .count(); // Output: 4

        // anyMatch
        boolean hasApple = Stream.of("apple", "banana", "cherry")
                .anyMatch(fruit -> fruit.equals("apple")); //outputs: true

        // allMatch
        boolean allLong = Stream.of("apple", "banana", "cherry")
                .allMatch(fruit -> fruit.length() > 4); // Output: true

        // noneMatch
        boolean noKiwi = Stream.of("apple", "banana", "cherry")
                .noneMatch(fruit -> fruit.equals("kiwi")); // Output: true

        // findFirst
        Optional<String> first = Stream.of("apple", "banana", "cherry")
                .findFirst(); // Output: Optional[apple]

        // findAny
        Optional<String> any = Stream.of("apple", "banana", "cherry")
                .findAny(); // Output: Optional[apple] (or any other element, especially with parallel streams)

        // min
        Optional<Integer> min = Stream.of(42, 7, 19)
                .min(Integer::compare); // Output: Optional[7]

        // max
        Optional<Integer> max = Stream.of(42, 7, 19)
                .max(Integer::compare); // Output: Optional[42]

        // toArray
        String[] arr = Stream.of("apple", "banana", "cherry")
                .toArray(String[]::new); // Output: ["apple", "banana", "cherry"]

        /*
        * Java provides specialized streams types for primitives: IntStream, LongStream, and DoubleStream.
        * These are more efficient than Stream<Integer>, etc. because they avoid boxing, unboxing.
        * */

        IntStream intStream1 = IntStream.of(1, 2, 3);
        LongStream longStream = LongStream.range(1, 5); // 1, 2, 3, 4
        DoubleStream doubleStream = DoubleStream.generate(Math::random).limit(3);

        int sum = IntStream.of(1, 2, 3).sum(); // 6
        OptionalDouble avg = IntStream.of(1, 2, 3).average(); // OptionalDouble[2.0]

        // Mapping Objects Streams
        Stream<String> names = Stream.of("alice", "bob");
        Stream<Integer> nameLengths = names.map(String::length);

        // Mapping Primitive Streams
        Stream<String> numbers = Stream.of("1", "2", "3");
        IntStream intStream2 = numbers.mapToInt(Integer::parseInt);

        IntStream intStream3 = IntStream.of(1, 2, 3);
        Stream<String> stringStream = intStream3.mapToObj(Integer::toHexString); // "1", "2", "3"

        // Parallel Streams

        List<String> listOfLetters = Arrays.asList("a", "b", "c", "d");
        listOfLetters.parallelStream().forEach(System.out::println);
        listOfLetters.stream().parallel().forEach(System.out::println);

    }
}

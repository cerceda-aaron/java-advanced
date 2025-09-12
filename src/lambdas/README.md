

## Functional Interfaces
A functional interface is an interface that has only one abstract method. This is known as the SAM 
(Single Abstract Method) rule.
- default methods do not count
- static method do not count
- methods inherited from Object do not count.

```java
@FunctionalInterface
interface SmapleFI{
    void m();
}
```

## Lambdas
- A lambda expression is just a block of code that helps in making your code more concise.
- A lambda expression only works with functional interfaces.
- A lambda expression is an instance of a class that implements a functional interface.
- Lambdas look a lot like methods and in some quarters are called "anonymous methods". However, it is an instance with everything but the method stripped away.

## Iterator

An **Iterator** is an object that lets you loop through a collection (like a `List` or `Set`) one item at a time.  
You use methods like `.hasNext()`, `.next()`, and `.remove()` to control your position and actions in the collection.

### Typical Usage

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Iterator<String> it = names.iterator();

while (it.hasNext()) {
    String name = it.next(); // Get next item
    System.out.println(name); // Do something with it
}
```

### Removing Items While Iterating

```java
while (it.hasNext()) {
    String name = it.next();
    if (name.equals("Bob")) {
        it.remove(); // Removes "Bob" from the list
    }
}
```

### Summary Table

| Method      | What it does                                 |
|-------------|----------------------------------------------|
| `hasNext()` | Returns `true` if there are more items       |
| `next()`    | Returns next item and moves the pointer      |
| `remove()`  | Removes the last item returned by `next()`   |

---

## Method References

**Method references** are a shorthand for calling existing methods using the double colon `::` syntax.  
They make code using lambdas cleaner and more readable.

### Types & Examples

| Type                                      | Lambda Expression        | Method Reference       |
|--------------------------------------------|-------------------------|-----------------------|
| Static method                             | `x -> Math.abs(x)`      | `Math::abs`           |
| Instance method of any object of a type    | `s -> s.toUpperCase()`  | `String::toUpperCase` |
| Instance method of a particular object     | `x -> str.toUpperCase()`| `str::toUpperCase`    |
| Constructor                               | `() -> new ArrayList<>()`| `ArrayList::new`      |

### Example

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Lambda way:
names.forEach(name -> System.out.println(name));

// Method reference way:
names.forEach(System.out::println);
```

### 1. Bound Method References

A **bound method reference** refers to an instance method of a specific object. The receiver is already known (bound) at the time the reference is created.

**Syntax:**  
`instance::methodName`

**Example:**
```java
String greeting = "Hello";
Supplier<Integer> lengthSupplier = greeting::length; // Bound to 'greeting'
System.out.println(lengthSupplier.get()); // Prints: 5
```

---

### 2. Unbound Method References

An **unbound method reference** refers to an instance method of a class, but the receiver (object) is not specified. It will be provided as a parameter when the method is invoked.

**Syntax:**  
`ClassName::instanceMethodName`

**Example:**
```java
Function<String, Integer> lengthFunction = String::length;
System.out.println(lengthFunction.apply("Hello")); // Prints: 5
```

---

### 3. Static Method References

A **static method reference** refers to a static method of a class.

**Syntax:**  
`ClassName::staticMethodName`

**Example:**
```java
Function<Integer, String> intToString = Integer::toString;
System.out.println(intToString.apply(42)); // Prints: "42"
```

---

### 4. Constructor Method References

A **constructor method reference** is used to refer to a class constructor.

**Syntax:**  
`ClassName::new`

**Example:**
```java
Supplier<List<String>> listSupplier = ArrayList::new;
List<String> list = listSupplier.get();
```

For constructors with arguments:
```java
Function<Integer, List<String>> listWithCapacity = ArrayList::new;
List<String> list = listWithCapacity.apply(10); // Creates ArrayList with initial capacity 10
```

---

### 5. The Importance of Context for Method References

The meaning and validity of a method reference depend heavily on the **target functional interface**—the expected method signature. The compiler uses this context to infer which method is being referenced and whether the reference is valid.

**Examples:**
- `String::toUpperCase` can be interpreted as:
    - `Function<String, String>` (unbound): expects a String input and returns a String output.
    - `Supplier<String>` (bound): if used as `"hello"::toUpperCase`, no input is needed.

**Incorrect Context Example:**
```java
// This will NOT compile:
Supplier<Integer> supplier = String::length; // Supplier takes no arguments, but String::length needs a String
```

**Correct Context Example:**
```java
Function<String, Integer> function = String::length; // Function takes a String and returns an Integer
```

---

## Summary Table

| Reference Type        | Syntax                 | Example                      | Context Required? |
|----------------------|------------------------|------------------------------|-------------------|
| Bound                | `instance::method`     | `greeting::length`           | Yes               |
| Unbound              | `Class::method`        | `String::length`             | Yes               |
| Static               | `Class::staticMethod`  | `Integer::toString`          | Yes               |
| Constructor          | `Class::new`           | `ArrayList::new`             | Yes               |

---

---

## What are Effectively Final Variables?

An **effectively final variable** in Java is a local variable whose value does not change after it is assigned. Even though it is not explicitly declared as `final`, it acts as if it is final because it’s never reassigned.

```java
String name = "Alice"; // effectively final
name = "Bob"; // now not effectively final
```

## Lambdas and Effectively Final Variables

When using **lambda expressions** (or anonymous inner classes) in Java, you can only reference local variables from the enclosing scope if they are final or effectively final.

**Why?**  
Lambdas may be executed after their enclosing method has returned, so the variable must not be modified to ensure predictability and thread safety.

### Example: Allowed Usage

```java
public void greet() {
    String greeting = "Hello"; // effectively final
    Runnable r = () -> System.out.println(greeting); // OK!
    r.run();
}
```

### Example: Not Allowed

```java
public void greet() {
    String greeting = "Hello";
    greeting = greeting + ", world!"; // reassigned, not effectively final
    Runnable r = () -> System.out.println(greeting); // Compile error!
}
```

## Why Does Java Require This?

- **Consistency:** Ensures the value captured by the lambda does not change unexpectedly.
- **Concurrency:** Prevents race conditions and bugs when lambdas are executed asynchronously.
- **Implementation:** Java lambdas capture variables by value, not by reference, so the value must be fixed.

## Practical Advice

- When using variables inside lambdas, assign their value once and do not modify them.
- If you need to mutate something inside a lambda, use fields or mutable objects (like arrays or collections), but be careful of concurrency issues.
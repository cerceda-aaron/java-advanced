# Generics

Generics was added in Java 5 to provide compile-time type checking and removing risk of ClassCastException that
was common while working with collections classes. The whole collection framework was re-written to use generics 
for type-safety.

```java
List list = new ArrayList();
list.add("abc");
list.add(new Integer(5)); //OK

for(Object obj : list){
 //type casting leading to ClassCastException at runtime
    String str=(String) obj; 
}
```

Above code compiles fine but throws ClassCastException at runtime because we are trying to cast Object in the list to 
String whereas one of the element is of type Integer. After Java 5, we use collection classes like below.

```java
List<String> list1 = new ArrayList<String>(); // java 7 ? List<String> list1 = new ArrayList<>(); 
list1.add("abc");
//list1.add(new Integer(5)); //compiler error

for(String str : list1){
     //no type casting needed, avoids ClassCastException
}
```
Notice that at the time of list creation, we have specified that the type of elements in the list will be String. 
So if we try to add any other type of object in the list, the program will throw compile-time error. 
Also notice that in for loop, we don’t need typecasting of the element in the list, hence removing the 
ClassCastException at runtime.

## Java Generic Class
We can define our own classes with generics type. A generic type is a class or interface that is parameterized 
over types. We use angle brackets (<>) to specify the type parameter. To understand the benefit.

## Java Generic Type

Java Generic Type Naming convention helps us understanding code easily and having a naming convention is one of the 
best practices of Java programming language. So generics also comes with its own naming conventions. Usually, type 
parameter names are single, uppercase letters to make it easily distinguishable from java variables. 
The most commonly used type parameter names are:

- E - Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
- K - Key (Used in Map)
- N - Number
- T - Type
- V - Value (Used in Map)
- S,U,V etc. - 2nd, 3rd, 4th types

## Java Generic Method

Sometimes we don’t want the whole class to be parameterized, in that case, we can create java generics method. 
Since the constructor is a special kind of method, we can use generics type in constructors too. 
Here is a class showing an example of a java generic method.

```java
package com.journaldev.generics;

public class GenericsMethods {

 //Java Generic Method
 public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){
  return g1.get().equals(g2.get());
 }
 
 public static void main(String args[]){
  GenericsType<String> g1 = new GenericsType<>();
  g1.set("Pankaj");
  
  GenericsType<String> g2 = new GenericsType<>();
  g2.set("Pankaj");
  
  boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);
  //above statement can be written simply as
  isEqual = GenericsMethods.isEqual(g1, g2);
  //This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets.
  //Compiler will infer the type that is needed
 }
}
```

Notice the isEqual method signature showing syntax to use generics type in methods. 
Also, notice how to use these methods in our java program. We can specify type while calling these methods or 
we can invoke them like a normal method. Java compiler is smart enough to determine the type of variable to be used,
this facility is called type inference.

## Java Generics Bounded Type Parameters
Suppose we want to restrict the type of objects that can be used in the parameterized type, for example in a method
that compares two objects and we want to make sure that the accepted objects are Comparables. To declare a bounded type
parameter, list the type parameter’s name, followed by the extends keyword, followed by its upper bound,
similar like below method.

```java
public static <T extends Comparable<T>> int compare(T t1, T t2){
  return t1.compareTo(t2);
}
```

The invocation of these methods is similar to unbounded method except that if we will try to use any class that is not 
Comparable, it will throw compile-time error. Bounded type parameters can be used with methods as well as classes and 
interfaces. Java Generics supports multiple bounds also, i.e <T extends A & B & C>. In this case, A can be an interface
or class. If A is class then B and C should be an interface. We can’t have more than one class in multiple bounds.


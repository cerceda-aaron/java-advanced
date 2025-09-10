package casting;

public class Main {
    public static void main(String[] args) {
        // ===== Widening Casting
        int myInt = 9;
        double myDouble = myInt; // Automatic casting: int to double
        System.out.println(myInt); // 9
        System.out.println(myDouble); // 9.0

        // ==== Narrowing Casting
        double doubleValue = 9.78d;
        int intValue = (int) doubleValue; // Manual casting: double to int

        System.out.println(doubleValue); // outputs 9.78
        System.out.println(intValue); // outputs 9

        // ===== Example
        int maxScore = 500;
        int userScore = 423;

        double percentage = (double) userScore / maxScore * 100.0d;
        System.out.println("User's percentage is " + percentage);

        /*
        *
        * Mainly there are two types of Explicit Casting
        * - Explicit Upcasting
        * - Explicit Downcasting
        *
        * 1.- Explicit Upcasting is the process of casting a subtype to a supertype in the inheritance tree's
        * upward direction. When a sub-class object is referenced by a superclass reference variable, an
        * automatic process is triggered without any further effort. (Assigning a child class object to a parent class reference. This happens automatically and is safe.)
        *
        * 2.- Explicit downcasting - when a subclass type refers to an object of the parent class, the process
        * is referred to as downcasting. If it is done manually, the compiler issues a runtime ClassCastException
        * error. It can only be done by using the instanceof operator. Only the downcast of an object that has
        * already been upcast is possible. (Assigning a parent class reference (that actually refers to a child object) back to a child class reference. This must be done manually and can cause errors if the object is not really of the child type.)
        *
        *  */

        // upcasting
        Animal animal = new Dog(); // Calls the overridden method in Dog class
        animal.makeSound(); // This would give a compile error as fetch() is not a method in Animal class

        if(animal instanceof Dog){
            Dog dog = (Dog) animal; // Explicit downcasting
            dog.fetch();
        }

        Animal secondAnimal = new Cat();
        secondAnimal.eat();

        // Explicit downcasting
        Cat cat = (Cat)secondAnimal;
        cat.meow();

        /*
        * Typecasting is also applicable to reference types, but must be done carefully. Casting an object to an
        * incompatible type will result in a ClassCastException at runtime.
        *
        * Object obj = "hello";         // A String stored in an Object
        * String s = (String) obj;      // Valid cast, no error
        * Integer i = (Integer) obj;    // Runtime error: ClassCastException
        *
        * to avoid such issues, it's good practice to use the instanceof operator before downcasting.
        *
        * if (obj instanceof String) {
        *   String s = (String) obj;
        *   System.out.println("String value: " + s);
        * }
        *
        * */

    }
}

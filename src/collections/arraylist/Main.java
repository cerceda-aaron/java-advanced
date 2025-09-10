package collections.arraylist;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> le = new MyArrayList<>();
        le.add(10);
        le.add(20);
        System.out.println(le.get(0));

        Tests tests = new Tests();
        tests.runTests();
    }
}

package collections.arraylist;

public class Tests {
    public void runTests() {
        testAdd();
        testDelete();
    }

    private void testAdd() {
        MyArrayList<Integer> le = new MyArrayList<Integer>();
        le.add(10);
        int result = le.get(0);
        if (result == 10) {
            System.out.println("testAdd passed.");
        } else {
            System.out.println("testAdd failed. Expected 10 but got " + result);
        }
    }

    private void testDelete() {
        MyArrayList<Integer> le = new MyArrayList<Integer>();
        le.add(10);
        le.add(20);
        le.remove(0);
        int result = le.get(0);
        if (result == 20) {
            System.out.println("testDelete passed.");
        } else {
            System.out.println("testDelete failed. Expected 20 but got " + result);
        }
    }
}

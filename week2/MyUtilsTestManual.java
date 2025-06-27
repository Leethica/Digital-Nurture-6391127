public class MyUtilsTestManual {
    static class MyUtils {
        public int add(int a, int b) {
            return a + b;
        }

        public String greet(String name) {
            return name == null ? null : "Hello, " + name;
        }

        public int[] getEvenNumbers() {
            return new int[] {2, 4, 6, 8};
        }

        public void divide(int a, int b) {
            int result = a / b; 
        }
    }

    public static void main(String[] args) {
        MyUtils utils = new MyUtils();

        if (utils.add(2, 3) == 5) {
            System.out.println("testAdd passed");
        } else {
            System.out.println("testAdd failed");
        }

        if ("Hello, Alice".equals(utils.greet("Alice"))) {
            System.out.println("testGreet with name passed");
        } else {
            System.out.println("testGreet with name failed");
        }

        if (utils.greet(null) == null) {
            System.out.println("testGreet null passed");
        } else {
            System.out.println("testGreet null failed");
        }

        int[] expected = {2, 4, 6, 8};
        int[] actual = utils.getEvenNumbers();
        boolean arraysEqual = true;
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                arraysEqual = false;
                break;
            }
        }
        if (arraysEqual) {
            System.out.println("testEvenNumbers passed");
        } else {
            System.out.println("testEvenNumbers failed");
        }

        try {
            utils.divide(10, 0);
            System.out.println("testDivideByZero failed (no exception thrown)");
        } catch (ArithmeticException e) {
            System.out.println("testDivideByZero passed (exception caught)");
        }

        if (10 > 5 && !(3 > 5)) {
            System.out.println("testBooleanConditions passed");
        } else {
            System.out.println("testBooleanConditions failed");
        }
    }
}

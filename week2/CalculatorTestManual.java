public class CalculatorTestManual {

    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        
        if (result == 5) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed. Expected 5 but got " + result);
        }
    }
}

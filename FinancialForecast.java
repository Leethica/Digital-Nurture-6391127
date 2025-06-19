import java.util.Scanner;

class FinancialForecast {
    private double[] pastIncomes;
    private int months;
    public FinancialForecast(int months) {
        this.months = months;
        pastIncomes = new double[months];
    }
    public void inputIncomes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter income for last " + months + " months:");
        for (int i = 0; i < months; i++) {
            System.out.print("Month " + (i + 1) + ": ");
            pastIncomes[i] = sc.nextDouble();
        }
    }
    public double calculateAverage() {
        double sum = 0;
        for (double income : pastIncomes) {
            sum += income;
        }
        return sum / months;
    }
    public void forecastNextMonth() {
        double avg = calculateAverage();
        System.out.printf("Predicted income for next month: ₹%.2f%n", avg);
    }
    public static void main(String[] args) {
        FinancialForecast forecast = new FinancialForecast(6);
        forecast.inputIncomes();
        forecast.forecastNextMonth();
    }
}
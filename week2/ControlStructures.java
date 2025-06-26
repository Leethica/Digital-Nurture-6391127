import java.util.Scanner;
public class ControlStructures {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        switch (number % 2) {
            case 0:
                System.out.println("The number is even.");
                break;
            case 1:
            case -1: // for negative odd numbers
                System.out.println("The number is odd.");
                break;
            default:
                System.out.println("Error checking even or odd.");
        }

        input.close();
    }
}

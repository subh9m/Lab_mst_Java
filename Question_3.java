import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (type 'done' to finish):");

        while (true) {
            String input = scanner.nextLine();

            if ("done".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }

        try {
            if (numbers.isEmpty()) {
                throw new ArithmeticException("The list is empty, cannot calculate average.");
            }

            double sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            double average = sum / numbers.size();

            System.out.println("Average: " + average);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


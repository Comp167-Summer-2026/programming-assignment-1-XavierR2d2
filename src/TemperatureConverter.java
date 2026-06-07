import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        // TODO: students implement this

        if (unit.equalsIgnoreCase("C")) {

            return temperature * (9.0 / 5) + 32;
        } else if (unit.equalsIgnoreCase("F")) {

            return (temperature - 32) * (5.0 / 9);
        }

        return 0.0;
    }

    // test 1

    public static void main(String[] args) {
        // TODO: students implement this

        Scanner scnr = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a temperature (or 'stop' to quit):");
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                running = false;
            } else {
                boolean validNumber = true;
                boolean decimalFound = false;

                int start = 0;
                if (input.length() > 0 && input.charAt(0) == '-') {
                    start = 1;
                }

                if (input.length() == start) {
                    validNumber = false;
                }

                for (int i = start; i < input.length(); i++) {
                    char ch = input.charAt(i);

                    if (ch == '.') {
                        if (decimalFound) {
                            validNumber = false;
                        }
                        decimalFound = true;
                    } else if (!Character.isDigit(ch)) {

                        validNumber = false;
                    }
                }

                if (!validNumber) {
                    System.out.println("Error: Invalid temperature value.");
                } else {
                    double temperature = Double.parseDouble(input);

                    System.out.print("Enter unit (C or F): ");
                    String unit = scnr.nextLine();

                    if (!unit.equalsIgnoreCase("C") &&
                            !unit.equalsIgnoreCase("F")) {

                        System.out.println("Error: Invaild unit.");
                    } else {
                        double convertedTemperature =
                                convertTemperature(temperature, unit);

                        if (unit.equalsIgnoreCase("C")) {
                            System.out.println(temperature + " C is equal to " + convertedTemperature + " F");
                        } else {
                            System.out.println( temperature + " F is equal to " + convertedTemperature + " C");
                        }
                    }
                }
            }
        }

        System.out.println("Program ended.");
        scnr.close();
    }
}
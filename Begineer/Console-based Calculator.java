import java.util.*;

public class CustomCalculator {

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("### Welcome to the Console Calculator ###");
            System.out.println("1. Perform Arithmetic Operations");
            System.out.println("2. Do Scientific Calculations");
            System.out.println("3. Convert Units");
            System.out.println("4. Quit");
            System.out.print("Please select an option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    handleArithmetic();
                    break;
                case 2:
                    handleScientific();
                    break;
                case 3:
                    handleConversions();
                    break;
                case 4:
                    System.out.println("Closing the calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        } while (option != 4);

        input.close();
    }

    public static void handleArithmetic() {
        System.out.println("## Arithmetic Operations ##");
        System.out.print("Input the first number: ");
        double number1 = input.nextDouble();
        System.out.print("Input the second number: ");
        double number2 = input.nextDouble();

        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Your choice: ");
        int operation = input.nextInt();

        switch (operation) {
            case 1:
                System.out.println("Result: " + (number1 + number2));
                break;
            case 2:
                System.out.println("Result: " + (number1 - number2));
                break;
            case 3:
                System.out.println("Result: " + (number1 * number2));
                break;
            case 4:
                if (number2 != 0) {
                    System.out.println("Result: " + (number1 / number2));
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Invalid operation selected.");
        }
    }

    public static void handleScientific() {
        System.out.println("## Scientific Calculations ##");
        System.out.println("1. Find Square Root");
        System.out.println("2. Exponential Calculation");
        System.out.print("Choose a calculation: ");
        int calcChoice = input.nextInt();

        switch (calcChoice) {
            case 1:
                System.out.print("Enter a value: ");
                double value = input.nextDouble();
                if (value >= 0) {
                    System.out.println("Square Root: " + Math.sqrt(value));
                } else {
                    System.out.println("Error: Negative value entered.");
                }
                break;
            case 2:
                System.out.print("Enter base value: ");
                double baseValue = input.nextDouble();
                System.out.print("Enter exponent: ");
                double powerValue = input.nextDouble();
                System.out.println("Result: " + Math.pow(baseValue, powerValue));
                break;
            default:
                System.out.println("Invalid calculation type.");
        }
    }

    public static void handleConversions() {
        System.out.println("## Unit Conversions ##");
        System.out.println("1. Temperature Converter");
        System.out.println("2. Currency Converter");
        System.out.print("Select a conversion type: ");
        int conversionType = input.nextInt();

        switch (conversionType) {
            case 1:
                convertTemperature();
                break;
            case 2:
                convertCurrency();
                break;
            default:
                System.out.println("Invalid conversion type selected.");
        }
    }

    public static void convertTemperature() {
        System.out.println("Temperature Conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose an option: ");
        int tempOption = input.nextInt();

        System.out.print("Enter temperature value: ");
        double temp = input.nextDouble();

        switch (tempOption) {
            case 1:
                double fahrenheitValue = (temp * 9/5) + 32;
                System.out.println("Temperature in Fahrenheit: " + fahrenheitValue);
                break;
            case 2:
                double celsiusValue = (temp - 32) * 5/9;
                System.out.println("Temperature in Celsius: " + celsiusValue);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void convertCurrency() {
        System.out.println("Currency Conversion:");
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.print("Choose conversion type: ");
        int currOption = input.nextInt();

        System.out.print("Enter amount: ");
        double amt = input.nextDouble();

        final double conversionRate = 82.0;

        switch (currOption) {
            case 1:
                double inrAmount = amt * conversionRate;
                System.out.println("Equivalent in INR: ₹" + inrAmount);
                break;
            case 2:
                double usdAmount = amt / conversionRate;
                System.out.println("Equivalent in USD: $" + usdAmount);
                break;
            default:
                System.out.println("Invalid currency conversion option.");
        }
    }
}

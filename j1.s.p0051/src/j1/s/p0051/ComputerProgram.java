package j1.s.p0051;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class ComputerProgram {

    /**
     * @param args the command line arguments
     */
    CheckValidtion check = new CheckValidtion();

    public void mennu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void normalCalculator() {
        double memory = 0;
        System.out.print("Enter number 1: ");
        memory = check.checkInputDouble();
        while (true) {

            System.out.print("Enter operator(+,-,*,/,=): ");
            String operator = check.checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                System.out.print("Enter number 2 :");
                double num2 = check.checkInputDouble();
                memory = memory + num2;
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                System.out.print("Enter number 2 :");
                double num2 = check.checkInputDouble();
                memory = memory - num2;
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                System.out.print("Enter number 2 :");
                double num2 = check.checkInputDouble();
                memory = memory * num2;
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                System.out.print("Enter number 2 :");
                double num2 = check.checkInputDouble();
                memory = memory / num2;
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                System.out.print("Enter number 2 :");
                double num2 = check.checkInputDouble();
                memory = Math.pow(memory, num2);
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }

    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    public void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = check.checkInputDouble();
        System.out.print("Enter Height(cm): ");
        double height = check.checkInputDouble();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}

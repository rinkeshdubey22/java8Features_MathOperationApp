package com.bridgelabz;

@FunctionalInterface
interface IMATHFUNCTION {
    int calculate(int a, int b);
    static void printResult(int a, int b, String function, IMATHFUNCTION fobj) {
        System.out.println("Result of " + function + " is " + fobj.calculate(a, b));
    }
}

public class MathOperationApp {
    public static void main(String[] args) {

        //This expression implements 'IMathFunction' interface
        IMATHFUNCTION add = Integer :: sum;

        //Lambda expression for subtraction multiplication & division for two parameters.
        //This expression implements 'IMathFunction'
        IMATHFUNCTION subtraction = (x,y) -> x - y;
        IMATHFUNCTION multiplication = (x,y) -> x * y;
        IMATHFUNCTION division = (int x, int y) -> x / y;

        //Addition Subtraction Multiplication & Division of Two Number Using Lambda Function
        System.out.println("Addition of Two Numbers is " + add.calculate(5,4));
        System.out.println("Subtraction of Two Numbers is " + subtraction.calculate(5,4));
        System.out.println("Multiplication of Two Numbers is " + multiplication.calculate(5,4));
        System.out.println("Division of Two Numbers is " + division.calculate(5,4));

        //Passing Lambda Expression As Function parameter To Print Result Using Static Function
        IMATHFUNCTION.printResult(5, 4, "Addition ", add);
        IMATHFUNCTION.printResult(5, 4, "Subtraction ", subtraction);
        IMATHFUNCTION.printResult(5, 4, "Multiplication ", multiplication);
        IMATHFUNCTION.printResult(5, 4, "Division ", division);
    }



}

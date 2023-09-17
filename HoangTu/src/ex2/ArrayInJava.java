package ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class addresses the problem in exercise number 2.
 *
 * @author Grizmo - Hoang Tuan Tu
 * @version 1.0
 *
 */

public class ArrayInJava {
    public static boolean[] primeNumbers(int number){
        boolean[] isPrime = new boolean[number + 1];
        for (int i = 2; i <= number; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= number; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= number; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }

    public static int maxArray(int[] numbers){
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if (numbers[i] > max){
                max = numbers[i];
            }
        }return max;
    }

    public static int inputSize(Scanner input){
        int size = 0;
        while (true){
            try{
                System.out.print("Input size for array: ");
                size = input.nextInt();
                if (size > 0)
                    return size;
                System.out.println("Please input a positive integer!");
            } catch (InputMismatchException e){
                System.out.println("Please input a positive integer!");
            }

        }
    }

    public static int[] inputArray(int size){
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++){
            while (true) {
                System.out.print("Input " + (i+1) + "-th number: ");
                String temp = input.nextLine();
                try {
                    numbers[i] = Integer.parseInt(temp);
                    break;
                } catch (Exception e) {
                    System.out.println("Only input an integer number!");
                }
            }
        }
        input.close();
        return numbers;
    }

    public static void printPrime(int[] numbers){
        boolean[] isPrime = primeNumbers(maxArray(numbers));
        System.out.print("Prime numbers are: ");
        for (int number: numbers){
            if (isPrime[number]){
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }


    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    public static void printEvenNumber(int[] numbers){
        System.out.print("Even numbers are: ");
        for (int number: numbers){
            if (isEven(number))
                System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = inputSize(input);
        int[] numbers = inputArray(size);
        printPrime(numbers);

        printEvenNumber(numbers);
        input.close();
    }
}

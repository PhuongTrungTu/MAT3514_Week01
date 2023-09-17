package ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseLine {
    public static List<String> inputData(int size){
        Scanner input = new Scanner(System.in);
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < size; i++){
            System.out.print("Input " + (i+1) + "/" + size + " line: ");
            String data = input.nextLine();
            result.add(data);
        }
        input.close();
        return result;
    }

    public static List<String> reverseLines(List<String> data){
        List<String> result = new ArrayList<String>();
        for (int i = data.size() - 1; i >= 0; i--){
            result.add(data.get(i));
        }
        return result;
    }

    public static void printReverse(List<String> data){
        System.out.println("Your lines in reverse order is: ");
        List<String> reverseData = reverseLines(data);
        for (String line: reverseData){
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        int size = 5;
        List<String> data = inputData(size);
        printReverse(data);

    }
}

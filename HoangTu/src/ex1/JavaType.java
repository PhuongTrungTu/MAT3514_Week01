package ex1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This class addresses the problem in exercise number 1.
 *
 * @author Grizmo - Hoang Tuan Tu
 * @version 1.0
 *
 */

public class JavaType {
    static Scanner input = new Scanner(System.in);

    /**
     * Prompts the user to choose a data type and returns their selection.
     *
     * @return The selected data type:
     *         - 0 if the user chooses Integer.
     *         - 1 if the user chooses Real Number.
     *         - 2 if the user chooses String.
     */
    public static int inputType(){
        System.out.println("Input type");
        System.out.println("0 - Integer number\n1- Real Number\n2 - String");
        while (true){
            System.out.print("Input type you want: ");
            String type = input.next();
            try {
                int temp = Integer.parseInt(type);
                if (temp >= 0 && temp <= 2){
                    return temp;
                }else{
                    System.out.println("Only input number 0 - 2 for type!");
                }
            } catch (Exception e) {
                System.out.println("Only input number 0 - 2 for type!");
            }
        }
    }

    /**
     * Takes a data type as input and prompts the user to enter a value of that type.
     * It then displays the entered value along with its data type.
     *
     * @param type An integer representing the data type to be entered:
     *             - 0 for Integer.
     *             - 1 for Real Number.
     *             - 2 for String.
     */
    public static void solution(int type) {
        HashMap<Integer, String> TYPE = new HashMap<>();
        TYPE.put(0, "Integer number");
        TYPE.put(1, "Real Number");
        TYPE.put(2, "String");

        while (true){
            try{
                System.out.print("Input a " + TYPE.get(type) + ": ");
                if (type == 0){
                    int number = input.nextInt();
                    System.out.println("Your variable have type " + TYPE.get(type) + ": " + number);
                    break;
                } else if (type == 1){
                    double number = input.nextDouble();
                    System.out.println("Your variable have type " + TYPE.get(type) + ": " + number);
                    break;
                } else {
                    String string = new Scanner(System.in).nextLine();
                    System.out.println("Your variable have type " + TYPE.get(type)  + ": " + string);
                    break;
                }
            }catch (Exception e){
                System.out.println("Exception!");
            }
        }
    }

    public static void main(String[] args) {
        solution(inputType());
    }
}


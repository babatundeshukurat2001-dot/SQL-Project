//write a program that collect a number as an integer but return it as long:
//input:5
//output:120

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        long result = 1;
        
        for (int count = 1; count <= number; count++) {
            result = result * count;
        }
        
        System.out.println(result);
    }
}

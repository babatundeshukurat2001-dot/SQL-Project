//ask user for a number and the divide the number by their prime factors


import java.util.Scanner;

public class PrimeFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int normalNumber = number;
        
        System.out.print("Prime factors of " + normalNumber + " are:  ");
        
        while (number % 2 == 0) {
            System.out.print(2 + " ");
            number = number / 2;
        }
        
        for (int count = 3; count <= Math.sqrt(number); count += 2) {
            while (number % count == 0) {
                System.out.print(count + " ");
                number = number / count;
            }
        }
       
        if (number > 2) {
            System.out.println(number);
        }
        
       
    }
}
        
        




























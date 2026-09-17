import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int number1 = input.nextInt();

        System.out.print("Enter Second Number: ");
        int number2 = input.nextInt();

        int lcm = 0;

        for (int count = 1; count <= number1 * number2; count++) {
            if (count % number1 == 0 && count % number2 == 0) {
                lcm = count;
//                break;
            }
        }

        System.out.println("LCM of " + number1 + " and " + number2 + " is: " + lcm);
        
       
    }
}

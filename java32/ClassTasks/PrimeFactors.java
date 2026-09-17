import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println("Prime factors of " + number + " are: ");

        for (int factor = 2; factor <= number; factor++) {
            while (number % factor == 0) {

                System.out.println(factor + " ");

                number /= factor;
            }
        }
        
      
    }
}

















//import java.util.Scanner;
//
//public class PrimeFactors {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Enter a number: ");
//        int number = input.nextInt();
//
//        System.out.println("Prime factors of " + number + " are: ");
//
//        for (int factor = 2; factor <= number; factor++) {
//
//            if (number % factor == 0) {
//                System.out.println(factor + " ");
//                number /= factor;
//                factor--; 
//            }
//        }
//        
//      
//    }
//}

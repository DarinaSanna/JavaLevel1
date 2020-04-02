import java.util.Scanner;
public class quadraticEquation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ax(2) + bx + c = 0");
        System.out.print("Enter a (a != 0):");
        double a = sc.nextInt();
        while (a == 0) {
            System.out.print("a cannot be 0. Enter another a:");
            a = sc.nextInt();
        }
        System.out.print("Enter b:");
        double b = sc.nextInt();
        System.out.print("Enter c:");
        double c = sc.nextInt();
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println ("x1 =" + x1);
            double x2 = (-b - Math.sqrt(d))/ (2 * a);
            System.out.println ("x2 = " + x2);
        }
        if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
        }
        if (d < 0) {
            System.out.println("No roots");
        }
    }
}

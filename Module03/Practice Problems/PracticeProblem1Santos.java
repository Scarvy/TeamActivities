import java.util.*;

/**
 * Problem name: HackerRank Challenge - Java Stdin and Stdout I
 *
 * Task: Read  integers from stdin and then print them to stdout.
 * Each integer must be printed on a new line.
 *
 * Submitted by: Abegail Santos
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter integer A: ");
        int a = scan.nextInt();
        System.out.print("Enter integer B: ");
        int b = scan.nextInt();
        System.out.print("Enter integer C: ");
        int c = scan.nextInt();

        scan.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
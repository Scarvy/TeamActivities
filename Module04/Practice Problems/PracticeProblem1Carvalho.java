import java.util.Scanner;

/**
 * Problem name: HackerRank Challenge - JJava Stdin and Stdout II
 *
 * Task: Read  integers from stdin and then print them to stdout.
 * Each integer must be printed on a new line.
 *
 * Submitted by: @Scarvy - Scott Carvalho
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        float d = scan.nextFloat();
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}

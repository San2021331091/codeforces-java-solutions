import java.util.Arrays;
import java.util.Scanner;

public class Black_Jack_104A {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            sc.nextLine();
            final int queenOfSpades = 10;
            final int upperBound = 25;
            int[] ways = new int[upperBound + 1];
            Arrays.fill(ways, 0);
            for (int k = queenOfSpades + 1; k <= queenOfSpades + 11; k++) {
                ways[k] = 4;
            }
            ways[2 * queenOfSpades] = 15;
            System.out.println(ways[n]);

        }

    }
}

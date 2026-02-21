import java.util.Scanner;

public class Sum_Of_Digits_102B {

    private static long sumOfDigits(long x) {

        long output = 0L;
        while (x > 0L) {

            output += x % 10L;
            x /= 10L;

        }
        return output;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();

            if (input.length() == 1) {
                System.out.println("0");
            }

            else {

                long current = 0L, times = 1L;

                for (int k = 0; k < input.length(); k++) {
                    current += input.charAt(k) - '0';
                }
                while (current > 9) {
                    current = sumOfDigits(current);
                    ++times;
                }

                System.out.println(times);

            }
        }

    }

}

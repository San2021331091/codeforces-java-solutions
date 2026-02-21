import java.util.Scanner;

public class Testing_Pants_For_Sadness_103A {    
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            long n = sc.nextLong();
            long total = 0L;
            for(int p = 0; p<n ; p++){
                long m = sc.nextLong();
                total += (m-1) * (p+1) + 1;
            }

            System.out.println(total);
        }

    }

}

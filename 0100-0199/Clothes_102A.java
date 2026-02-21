import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Clothes_102A {

  public record Pair<T, F>(T first, F second) {

  }

  public static void main(String[] args) {

    long n, m;
    try (Scanner sc = new Scanner(System.in)) {
      n = sc.nextLong();
      m = sc.nextLong();

      long[] priceVec = new long[(int) n];

      Arrays.fill(priceVec, 0L);
      for (int p = 0; p < n; p++) {
        priceVec[p] = sc.nextLong();
      }

      SortedSet<Pair<Long, Long>> matchSet = new TreeSet<>(
          Comparator.<Pair<Long, Long>, Long>comparing(p -> p.first)
              .thenComparing(p -> p.second));

      for (int p = 0; p < m; p++) {

        long a = sc.nextLong();
        long b = sc.nextLong();

        if (b < a) {
          long temp = a;
          a = b;
          b = temp;
        }
        matchSet.add(new Pair<>(a - 1L, b - 1L));
      }

      long minCost = (long) 1e7;
      for (int x = 0; x < n; x++) {
        for (int y = x + 1; y < n; y++) {
          for (int z = y + 1; z < n; z++) {

            long currentPrice = priceVec[x] + priceVec[y] + priceVec[z];

            if (matchSet.contains(new Pair<>((long) x, (long) y)) &&
                matchSet.contains(new Pair<>((long) y, (long) z)) &&
                matchSet.contains(new Pair<>((long) x, (long) z)) &&
                currentPrice < minCost) {

              minCost = currentPrice;
            }
          }

        }

      }

      System.out.println(minCost < (long) 1e7 ? minCost : "-1");
    }
  }
}

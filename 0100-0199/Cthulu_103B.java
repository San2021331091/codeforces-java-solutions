import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Cthulu_103B {

    private static List<List<Integer>> edges;
    private static boolean[] visited;
    private static int totalVisited;

    private static void dfs(int node) {

        if (visited[node])
            return;

        visited[node] = true;
        ++totalVisited;

        var itr = edges.get(node).iterator();
        for (;itr.hasNext();) {
            dfs(itr.next());
        }

    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String[] input = sc.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            edges = new LinkedList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new LinkedList<>());
            }
            visited = new boolean[n + 1];
            for (int p = 0; p < m; p++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                edges.get(a).add(b);
                edges.get(b).add(a);
            }

            dfs(1);

            System.out.println((totalVisited < n || m != n) ? "NO" : "FHTAGN!");
        }

    }

}

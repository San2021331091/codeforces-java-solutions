import java.util.*;

public class Transmigration_105A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minLevel = 100;
        double eps = 0.001;

        int n = sc.nextInt();
        int m = sc.nextInt();
        double k = sc.nextDouble();

        SortedMap<String, Long> skillMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String skill = sc.next();
            int level = sc.nextInt();
            if (k * level >= minLevel) {
    
                skillMap.put(skill, (long) Math.floor(k * level + eps));
            }
        }

        for (int i = 0; i < m; i++) {
            String bannedSkill = sc.next();
            skillMap.putIfAbsent(bannedSkill, 0L);
        }

        System.out.println(skillMap.size());
        for (var entry : skillMap.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue());
            System.out.print(" ");  
            System.out.println();
        }

        sc.close();
    }
}
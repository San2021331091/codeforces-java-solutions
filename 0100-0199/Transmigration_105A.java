import java.util.*;

public class Transmigration_105A {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int minLevel = 100;
            double eps = 0.001;

            int n = sc.nextInt();
            int m = sc.nextInt();
            double k = sc.nextDouble();

            Map<String, Long> skillMap = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                String skill = sc.next();
                int level = sc.nextInt();
                if (k * level >= minLevel) {
                    skillMap.put(skill, Math.round(k * level + eps));
                }
            }

        
            for (int i = 0; i < m; i++) {
                String bannedSkill = sc.next();
                if (!skillMap.containsKey(bannedSkill)) {
                    skillMap.put(bannedSkill, 0L);
                }
            }

           
            List<String> skillList = new ArrayList<>(skillMap.keySet());
            Collections.sort(skillList);

            System.out.println(skillList.size());
            var skillListIterator = skillList.iterator();
            for (; skillListIterator.hasNext();) {
                System.out.println(skillListIterator.next() + " " + skillMap.get(skillListIterator.next()));
            }
        }
    }
}
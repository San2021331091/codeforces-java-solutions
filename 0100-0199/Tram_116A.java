import java.io.*;
import java.util.StringTokenizer;

public class Tram_116A {
    public static void main(String... args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            var printer = new PrintWriter(new BufferedOutputStream(System.out));
            int numStops = Integer.parseInt(br.readLine());
            int curCapacity = 0, maxCapacity = 0, out, in;

            while (--numStops >= 0) {
                var tokenizer = new StringTokenizer(br.readLine());
                out = Integer.parseInt(tokenizer.nextToken());
                in = Integer.parseInt(tokenizer.nextToken());
                curCapacity += in - out;
                if(curCapacity > maxCapacity){
                    maxCapacity = curCapacity;
                }

            }
            printer.println(maxCapacity);
            printer.flush();
            printer.close();


        } catch (IOException e) {
            System.err.println(e.getMessage());

        }
    }
}

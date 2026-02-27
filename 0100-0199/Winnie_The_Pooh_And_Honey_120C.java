import java.io.*;
import java.util.Arrays;

public class Winnie_The_Pooh_And_Honey_120C {
    public static void main(String[] args) {

        try {
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
            int n,k;
            var lines = Arrays.stream(input.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            n = lines[0];
            k = lines[1];
            var total = 0;

            var input1 = input.readLine().trim().split("\\s+");
            for(String q : input1){

                int quantity = Integer.parseInt(q);
                if(quantity < k){
                    total += quantity;
                }
                else if(quantity <= 3 * k){
                    total += quantity % k;
                }
                else {
                    total += quantity - 3*k;
                }


            }

            System.out.println(total);
            output.write(total+"\n");
            output.flush();
            output.close();

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}

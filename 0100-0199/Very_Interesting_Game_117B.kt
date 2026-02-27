import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val output = PrintWriter(BufferedOutputStream(System.`out`))
    val (a,b,mod) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
    for(p in 1L .. a){
        if(p> mod)
            break
        if((mod - (p * 1000000000L) % mod) % mod > b){
            output.print("1 "+ String.format("%09d",p))
            output.flush()
            return
        }
    }

    output.println("2")
    reader.close()
    output.flush()
    output.close()

}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val printer = PrintWriter(System.out)
    val k = reader.readLine().toLong()
    val m = reader.readLine().toLong()
    var temp = k
    var times = 0
    while (temp < m){
        temp *= k
        times++
    }
    if(temp == m){
        printer.print("YES\n${times}")
    }
    else{
        printer.println("NO")
    }

    reader.close()
    printer.flush()

}
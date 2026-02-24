import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val out = PrintWriter(System.out)
    val n = reader.readLine().toLong()
    val bits = MutableList(n.toInt()) { 0L }
    val values = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }
    for (p in 0 until n) {
        bits[p.toInt()] = values[p.toInt()]
    }
    bits.sort()
    var output = "NO"
    for (p in 1..<n) {
        if (bits[p.toInt() - 1] != bits[p.toInt()] && 2 * bits[p.toInt() - 1] > bits[p.toInt()]) {
            output = "YES"
            break
        }
    }

    out.println(output)
    reader.close()
    out.flush()

}
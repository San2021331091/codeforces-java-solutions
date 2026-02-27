import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val printer = PrintWriter(BufferedOutputStream(System.`out`))
    val (n, m) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
    repeat(n.toInt()) {

        val tokenizer = StringTokenizer(reader.readLine())
        var s = tokenizer.nextToken().toLong()
        var f = tokenizer.nextToken().toLong()
        val t = tokenizer.nextToken().toLong()
        var output: Long
        if (s == f) {
            output = t
        } else {

            val p = 2L * (m - 1L)
            --s
            --f
            output = (t / p) * p
            if (s < f && (output + s) < t) {
                output += p
            } else if (s > f && (output + p - s) < t) {
                output += p
            }
            output += if (s < f) f else (p - f)

        }

        printer.println(output)
    }

    reader.close()
    printer.flush()
    printer.close()
}
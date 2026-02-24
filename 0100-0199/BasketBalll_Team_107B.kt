import java.io.*

fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val out = PrintWriter(System.out)

    val (n, m, h) = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }
    val a = MutableList(m.toInt() + 1) { 0L }

    var sum = 0L

    val values = reader.readLine().trim().split("\\s+".toRegex()).map { it.toLong() }

    for (p in 1..m.toInt()) {
        a[p] = values[p-1]
        sum += a[p]
    }
    if (sum < n)
        println("-1")

    else{

        var s = 1.0
        for (p in 1 until n.toInt()) {
            s = s * (sum + 1 - a[h.toInt()] - p) / (sum - p);
        }
        out.println("%.10f".format(1-s))

    }

    reader.close()
    out.flush()

}
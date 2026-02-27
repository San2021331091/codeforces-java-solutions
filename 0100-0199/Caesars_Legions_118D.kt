const val M = 100000000
fun main() {

    val reader = System.`in`.bufferedReader()
    val printer = System.`out`.bufferedWriter()
    val (n1,n2,k1,k2) = reader.readLine().trim().split("\\s+".toRegex()).map{ it.toLong() }.toLongArray()
    val f = Array((1L+n1).toInt()) { LongArray((1L+n2).toInt()) { 0L } }
    val g = Array((1L+n1).toInt()) { LongArray((1L+n2).toInt()) { 0L } }
    f[0][0] = 1L
    g[0][0] = 1L

    for (row in 0..n1) {
        for (col in 0..n2) {
            run {
                var u = 1L
                while (u <= k1 && u <= row) {
                    f[row.toInt()][col.toInt()] += g[(row - u).toInt()][col.toInt()]
                    u++
                }
            }
            var u = 1L
            while (u <= k2 && u <= col) {
                g[row.toInt()][col.toInt()] += f[row.toInt()][(col - u).toInt()]
                u++
            }
            f[row.toInt()][col.toInt()] %= M
            g[row.toInt()][col.toInt()] %= M
        }
    }
    val res = (f[n1.toInt()][n2.toInt()] + g[n1.toInt()][n2.toInt()]) % M

    printer.write("$res")
    reader.close()
    printer.flush()
    printer.close()


}
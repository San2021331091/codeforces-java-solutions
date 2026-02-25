const val N = (1e5 + 7).toLong()
fun main() {

    val v = MutableList(N.toInt()) { 0L }
    val n = readln().toLong()
    for (p in 1L..n) {
        val (x, y) = readln().trim().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
        var count = 0L
        for (a in 1L..x) {
            if (a * a > x)
                break
            if (x % a != 0L)
                continue

            val b = x / a
            if (v[a.toInt()] < p - y) {
                count++

            }
            v[a.toInt()] = p
            if (v[b.toInt()] < p - y) {
                count++

            }
            v[b.toInt()] = p
        }

        println(count)
    }
}
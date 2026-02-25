fun countOnes(v: List<Boolean>): Int = v.count { it }

fun getBinaryVector(x: Long, n: Int): List<Boolean> {
    val v = MutableList(n) { false }
    var p = x
    var idx = 0
    while (p > 0 && idx < n) {
        v[idx] = (p % 2L == 1L)
        p /= 2L
        idx++
    }
    return v
}

fun main() {
    val (n, m) = readln().trim().split("\\s+".toRegex()).map { it.toInt() }
    val nmap = mutableMapOf<String, Int>()
    val nmv = MutableList(n) { "" }
    repeat(n) {
        val name = readln()
        nmap[name] = it
        nmv[it] = name
    }

    val enset = mutableSetOf<Pair<Int, Int>>()
    repeat(m) {
        val (x, y) = readln().trim().split("\\s+".toRegex())
        val u = nmap[x]!!
        val v = nmap[y]!!
        enset.add(u to v)
        enset.add(v to u)
    }

    val clique = sortedSetOf<String>()
    val maxMask = 1L shl n
    for (mask in 1L until maxMask) {
        val bv = getBinaryVector(mask, n)
        var possible = true
        loop@ for (x in 0 until n) {
            if (!bv[x]) continue
            for (y in x + 1 until n) {
                if (!bv[y]) continue
                if (enset.contains(x to y)) {
                    possible = false
                    break@loop
                }
            }
        }
        if (possible) {
            val cnt = countOnes(bv)
            if (cnt > clique.size) {
                clique.clear()
                for (i in 0 until n) if (bv[i]) clique.add(nmv[i])
            }
        }
    }

    println(clique.size)
    clique.forEach { println(it) }
}
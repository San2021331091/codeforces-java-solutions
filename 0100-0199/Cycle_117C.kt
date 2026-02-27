fun dfs(
    node: Int,
    from: Int,
    g: Array<BooleanArray>,
    visited: BooleanArray,
    cycle: MutableList<Int>
) {
    if (visited[node] || cycle.isNotEmpty()) return
    visited[node] = true

    for (u in g[node].indices) {
        if (!g[node][u]) continue
        if (from >= 0 && g[u][from]) {
            cycle.add(from + 1)
            cycle.add(node + 1)
            cycle.add(u + 1)
            return
        }
        if (!visited[u]) dfs(u, node, g, visited, cycle)
    }
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.`out`.bufferedWriter()
    val n = reader.readLine().toInt()
    val g = Array(n) { BooleanArray(n) }

    repeat(n) { i ->
        val s = reader.readLine()
        for (j in s.indices) g[i][j] = s[j] == '1'
    }

    val visited = BooleanArray(n)
    val cycle = mutableListOf<Int>()

    for (i in 0 until n) {
        if (!visited[i]) dfs(i, -1, g, visited, cycle)
        if (cycle.isNotEmpty()) break
    }

    if (cycle.size >= 3) {
        writer.write("${cycle[0]} ")
        writer.write("${cycle[1]} ")
        writer.write("${cycle[2]}\n")
    }

    else writer.write("-1\n")
    reader.close()
    writer.close()

}
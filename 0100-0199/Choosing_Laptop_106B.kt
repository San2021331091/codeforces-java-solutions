fun main() {

    val n = readln().toInt()
    val laptop = mutableListOf<MutableList<Int>>()

    for (k in 0 until n) {
        val arr = MutableList(4) { 0 }
        laptop.add(arr)

        val (speed, ram, hdd, cost) = readln().split(" ").map { it.toInt() }
        laptop[k][0] = speed
        laptop[k][1] = ram
        laptop[k][2] = hdd
        laptop[k][3] = cost

    }
    val candidate = BooleanArray(n)
    for (k in 0 until n) {
        candidate[k] = true
    }
    for (a in 0 until n) {
        for (b in 0 until n) {
            if (a == b) continue
            if (laptop[a][0] < laptop[b][0] && laptop[a][1] < laptop[b][1] && laptop[a][2] < laptop[b][2] && laptop[a][3] < laptop[b][3]) {
                candidate[a] = false
                break
            }

        }
    }

    var bestLaptop = -1
    var bestPrice = 1001

    for (k in 0 until n) {
        if (!candidate[k]) continue
        if (laptop[k][3] < bestPrice) {
            bestPrice = laptop[k][3]
            bestLaptop = k
        }
    }

    println(bestLaptop + 1)


}
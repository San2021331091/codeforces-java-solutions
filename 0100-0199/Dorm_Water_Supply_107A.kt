data class Wedge(val source:Int, val target: Int, val diameter: Long)

fun main() {

    val (n,p) = readln().split(" ").map { it.toInt() }
    val degrees = MutableList(n+1){ 0 }
    val edges = HashMap<Int, Pair<Int,Long>>()

    repeat(p){

        val (from,to,cap) = readln().split(" ").map { it.toInt() }
        --degrees[from]
        ++degrees[to]
        edges.putIfAbsent(from,Pair(to,cap.toLong()))

    }

    val combined = mutableListOf<Wedge>()
    for( h in 1 .. n){
        if(degrees[h] >= 0)
            continue

        var cap = (1e6).toLong() + 1L
        var tap = h
        while (edges.containsKey(tap)){
            if(edges[tap]!!.second < cap){
                cap = edges[tap]!!.second
            }
            tap = edges[tap]!!.first
        }

        val temp = Wedge(source = h, target = tap, diameter = cap);

        combined.add(temp)
    }
    println(combined.size)

    for(p in combined){
        println("${p.source} ${p.target} ${p.diameter}")
    }

}
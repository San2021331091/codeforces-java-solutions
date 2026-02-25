fun main() {

    val (n,x,y) = readln().trim().split("\\s+".toRegex()).map { it.toLong() }
    var possible = true

    val numbers = MutableList(n.toInt()) { 1L }
    numbers[n.toInt() - 1] = (y - (n-1))

     if(numbers[n.toInt()-1] <= 0L){
         possible = false
     }
    var sumOfSquares = 0L
    for(p in 0 until n.toInt()){
        sumOfSquares += numbers[p] * numbers[p]

    }
    if(sumOfSquares < x){
        possible = false
    }
    if(possible){
        for (p in 0 until n){
            print("${numbers[p.toInt()]} ")
        }
        println()
    }
    else{
        println("-1")
    }

}
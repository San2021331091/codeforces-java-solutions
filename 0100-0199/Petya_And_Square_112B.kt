fun main() {

    val (p,x,y) = readln().trim().split("\\s+".toRegex()).map { it.toInt() }
    val n = p/2
    if((x == n || x == n+ 1) && (y ==n || y== n+1)){
        println("NO")
    }
    else{
        println("YES")
    }

}
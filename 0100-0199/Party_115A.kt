fun main() {

    val n = readln().toInt()
    val sup = IntArray(n+1)
    for(k in 1 .. n){
        sup[k] = readln().toInt()
    }
    var total = 0
    for(k in 1 .. n){
        var temp = 1
        var  boss = sup[k]
        while(boss!=-1){
            boss = sup[boss]
            ++temp
        }
        if(temp > total){
            total = temp
        }
    }
    println(total)

}
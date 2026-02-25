fun main() {

    val n = readln().toLong()
    for (k in 0 until n){

        val res = (k % 4).toInt()
        when(res){
            0 -> print('a')
            1 -> print('b')
            2 -> print('c')
            3 -> print('d')
        }
    }
    println()

}
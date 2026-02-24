fun main() {

    val n = readln().toLong()
    var numSevens = -1L
    var numFours = -1L
    var minDigits = 1e6.toLong()
    for(testSevens in n/7 downTo 0){

        if (((n - 7 * testSevens) % 4 ) != 0L) {
            continue
        }
        val testFours = (n - 7 * testSevens) / 4
        numSevens = testSevens
        numFours = testFours
        minDigits = numSevens + numFours
        break

    }

    if(numSevens >= 0 && numFours >= 0)
    {
        repeat(numFours.toInt()){
            print("4")
        }
        repeat(numSevens.toInt()){
            print("7")
        }
    }
    else{
        print("-1")
    }

    println()

}
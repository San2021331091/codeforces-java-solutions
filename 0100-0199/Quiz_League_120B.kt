import java.io.File

fun main() {
    val input = File("input.txt").readLines()
    val (n,k) = input[0].trim().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
    val numbers = input[1].trim().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
    var noneSoFar = true
    var firstUnanswered = 0

    for (p in 1 .. n){

        val temp = numbers[p-1]
        if(temp!=0){
            if(p>=k){
                firstUnanswered = p
                break
            }
            else if(noneSoFar){
                firstUnanswered = p
                noneSoFar = false
            }
        }
    }

    File("output.txt").writeText(firstUnanswered.toString())
}
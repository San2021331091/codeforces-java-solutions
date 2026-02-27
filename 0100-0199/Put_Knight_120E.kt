import java.io.File

fun main() {

    val input = File("input.txt").readLines()
    val t = input[0].toInt()
    val writer = File("output.txt").bufferedWriter()
    for(i in 1..t){
        val n = input[i].toInt()
        writer.write(if(n%2L == 0L) "1\n" else "0\n")

    }

    writer.flush()
    writer.close()
}
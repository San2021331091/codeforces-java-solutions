import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.StringTokenizer


fun main() {

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val output = PrintWriter(BufferedOutputStream(System.`out`))
    val tokenizer = StringTokenizer(reader.readLine())
    val n = tokenizer.nextToken().toInt()
    val m = tokenizer.nextToken().toInt()
    val array = mutableListOf<String>()

    repeat (n) {
        val line = reader.readLine()
        array.add(line)
    }
    var eligiblePigs = 0
    var eligibleWolves = 0

    for (row in 0 until n) {
        for (col in 0 until m) {
            val currentCell = array[row][col]
            if (currentCell == '.') continue
            if (currentCell == 'P') {
                if ((row > 0 && array[row - 1][col] == 'W') || (row < n - 1 && array[row + 1][col] == 'W') || (col > 0 && array[row][col - 1] == 'W') || (col < m - 1 && array[row][col + 1] == 'W')) {
                    ++eligiblePigs
                }
            }
            if (currentCell == 'W') {
                if ((row > 0 && array[row - 1][col] == 'P') || (row < n - 1 && array[row + 1][col] == 'P') || (col > 0 && array[row][col - 1] == 'P') || (col < m - 1 && array[row][col + 1] == 'P')) {
                    ++eligibleWolves
                }
            }
        }
    }

    output.println(minOf(eligiblePigs, eligibleWolves))
    reader.close()
    output.flush()
    output.close()

}




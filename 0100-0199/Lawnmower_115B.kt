import java.util.StringTokenizer
import java.io.BufferedReader
import java.io.BufferedOutputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import kotlin.math.abs

class FastReader{
    private var reader: BufferedReader
    private var tokenizer: StringTokenizer
    constructor(){
        tokenizer = StringTokenizer("")
         reader = BufferedReader(InputStreamReader(System.`in`))

    }
    operator fun next(): String {
        while (!tokenizer.hasMoreElements()) {
            val line = reader.readLine()
            tokenizer = StringTokenizer(line)
        }
        return tokenizer.nextToken()
    }

    fun nextInt(): Int = next().toInt()
}

fun main() {
    val fr = FastReader()
    val out = PrintWriter(BufferedOutputStream(System.`out`))

    val rString = fr.next()
    val rows = rString.toInt()
    val cols = fr.nextInt()

    val grid = MutableList(rows) { fr.next() }

    var currRow = 0L
    var currCol = 0L
    var totalDistance = 0L

    for (r in 0 until rows) {
        val isOddRow = r % 2 != 0

        if (isOddRow) {

            for (c in (cols - 1) downTo 0) {
                if (grid[r][c] == 'W') {
                    totalDistance += abs(currRow - r) + abs(currCol - c)
                    currRow = r.toLong()
                    currCol = c.toLong()
                }
            }
        } else {
            for (c in 0 until cols) {
                if (grid[r][c] == 'W') {
                    totalDistance += abs(currRow - r) + abs(currCol - c)
                    currRow = r.toLong()
                    currCol = c.toLong()
                }
            }
        }
    }

    out.println(totalDistance)
    out.flush()
    out.close()
}